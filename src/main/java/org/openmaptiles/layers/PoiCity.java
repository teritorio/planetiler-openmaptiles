/*
Copyright (c) 2021, MapTiler.com & OpenMapTiles contributors.
All rights reserved.

Code license: BSD 3-Clause License

Redistribution and use in source and binary forms, with or without
modification, are permitted provided that the following conditions are met:

* Redistributions of source code must retain the above copyright notice, this
  list of conditions and the following disclaimer.

* Redistributions in binary form must reproduce the above copyright notice,
  this list of conditions and the following disclaimer in the documentation
  and/or other materials provided with the distribution.

* Neither the name of the copyright holder nor the names of its
  contributors may be used to endorse or promote products derived from
  this software without specific prior written permission.

THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS "AS IS"
AND ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED TO, THE
IMPLIED WARRANTIES OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR PURPOSE ARE
DISCLAIMED. IN NO EVENT SHALL THE COPYRIGHT HOLDER OR CONTRIBUTORS BE LIABLE
FOR ANY DIRECT, INDIRECT, INCIDENTAL, SPECIAL, EXEMPLARY, OR CONSEQUENTIAL
DAMAGES (INCLUDING, BUT NOT LIMITED TO, PROCUREMENT OF SUBSTITUTE GOODS OR
SERVICES; LOSS OF USE, DATA, OR PROFITS; OR BUSINESS INTERRUPTION) HOWEVER
CAUSED AND ON ANY THEORY OF LIABILITY, WHETHER IN CONTRACT, STRICT LIABILITY,
OR TORT (INCLUDING NEGLIGENCE OR OTHERWISE) ARISING IN ANY WAY OUT OF THE USE
OF THIS SOFTWARE, EVEN IF ADVISED OF THE POSSIBILITY OF SUCH DAMAGE.

Design license: CC-BY 4.0

See https://github.com/openmaptiles/openmaptiles/blob/master/LICENSE.md for details on usage
*/
package org.openmaptiles.layers;

import static org.openmaptiles.util.Utils.nullIfLong;

import com.carrotsearch.hppc.LongIntMap;
import com.onthegomap.planetiler.FeatureCollector;
import com.onthegomap.planetiler.ForwardingProfile;
import com.onthegomap.planetiler.VectorTile;
import com.onthegomap.planetiler.collection.Hppc;
import com.onthegomap.planetiler.config.PlanetilerConfig;
import com.onthegomap.planetiler.reader.WithTags;
import com.onthegomap.planetiler.stats.Stats;
import com.onthegomap.planetiler.util.Parse;
import com.onthegomap.planetiler.util.Translations;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import org.openmaptiles.generated.OpenMapTilesSchema;
import org.openmaptiles.generated.Tables;
import org.openmaptiles.layers.PoiCityClass.PoiClass;
import org.openmaptiles.util.OmtLanguageUtils;

public class PoiCity implements
  OpenMapTilesSchema.PoiCity,
  Tables.OsmPoiCityPoint.Handler,
  Tables.OsmPoiCityPolygon.Handler,
  ForwardingProfile.FeaturePostProcessor {

  /*
   * process() creates the raw POI feature from OSM elements and postProcess()
   * assigns the feature rank from order in the tile at render-time.
   */

  private final Translations translations;

  public PoiCity(Translations translations, PlanetilerConfig config, Stats stats) {
    this.translations = translations;
  }

  private PoiClass matchPoiClass(WithTags element) {
    List<PoiClass> pois = PoiCityClass.POI_CLASS.getMatches(element);
    return pois.size() >= 1 ? Collections.min(pois, Comparator.<PoiClass>comparingInt(r -> r.zoom())
      .thenComparingInt(r -> r.priority())) : null;
  }

  @Override
  public void process(Tables.OsmPoiCityPoint element, FeatureCollector features) {
    PoiClass poiClass = matchPoiClass(element.source());
    if (poiClass != null) {
      setupPoiFeature(element, poiClass, features.point(LAYER_NAME));
    }
  }

  @Override
  public void process(Tables.OsmPoiCityPolygon element, FeatureCollector features) {
    PoiClass poiClass = matchPoiClass(element.source());
    if (poiClass != null) {
      setupPoiFeature(element, poiClass, features.centroidIfConvex(LAYER_NAME));
    }
  }

  private <T extends Tables.WithName & Tables.WithLayer & Tables.WithSource & Tables.WithIndoor> void setupPoiFeature(
    T element, PoiClass poiClass, FeatureCollector.Feature output) {
    output.setBufferPixels(BUFFER_SIZE)
      .setAttr(Fields.SUPERCLASS, poiClass.superclass())
      .setAttr(Fields.CLASS, poiClass.class_())
      .setAttr(Fields.SUBCLASS, poiClass.subclass())
      .setAttr(Fields.ZOOM, poiClass.zoom())
      .setAttr(Fields.PRIORITY, poiClass.priority())
      .setAttr(Fields.STYLE, poiClass.style())
      .setAttr(Fields.LAYER, nullIfLong(element.layer(), 0))
      .setAttr(Fields.LEVEL, Parse.parseLongOrNull(element.source().getTag("level")))
      .setAttr(Fields.INDOOR, element.indoor() ? 1 : null)
      .putAttrs(OmtLanguageUtils.getNames(element.source().tags(), translations))
      .setPointLabelGridPixelSize(14, 64)
      .setSortKey(poiClass.zoom() * 10000 + poiClass.priority())
      .setMinZoom(poiClass.zoom() > 14 ? 14 : poiClass.zoom());
  }

  @Override
  public List<VectorTile.Feature> postProcess(int zoom, List<VectorTile.Feature> items) {
    // infer the "rank" field from the order of features within each label grid
    // square
    LongIntMap groupCounts = Hppc.newLongIntHashMap();
    for (VectorTile.Feature feature : items) {
      int gridrank = groupCounts.getOrDefault(feature.group(), 1);
      groupCounts.put(feature.group(), gridrank + 1);
      if (!feature.attrs().containsKey(Fields.RANK)) {
        feature.attrs().put(Fields.RANK, gridrank);
      }
    }
    return items;
  }
}
