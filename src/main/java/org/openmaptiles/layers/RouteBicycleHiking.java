package org.openmaptiles.layers;

import static com.onthegomap.planetiler.util.MemoryEstimator.CLASS_HEADER_BYTES;
import static com.onthegomap.planetiler.util.MemoryEstimator.INT_BYTES;
import static com.onthegomap.planetiler.util.MemoryEstimator.POINTER_BYTES;
import static com.onthegomap.planetiler.util.MemoryEstimator.estimateSize;
import static java.util.Map.entry;
import static org.openmaptiles.util.Utils.*;

import com.onthegomap.planetiler.FeatureCollector;
import com.onthegomap.planetiler.FeatureMerge;
import com.onthegomap.planetiler.VectorTile;
import com.onthegomap.planetiler.config.PlanetilerConfig;
import com.onthegomap.planetiler.reader.osm.OsmElement;
import com.onthegomap.planetiler.reader.osm.OsmReader;
import com.onthegomap.planetiler.reader.osm.OsmRelationInfo;
import com.onthegomap.planetiler.stats.Stats;
import com.onthegomap.planetiler.util.MemoryEstimator;
import com.onthegomap.planetiler.util.Translations;
import com.onthegomap.planetiler.util.ZoomFunction;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import org.openmaptiles.OpenMapTilesProfile;
import org.openmaptiles.generated.OpenMapTilesSchema;
import org.openmaptiles.generated.Tables;

public class RouteBicycleHiking implements
  OpenMapTilesSchema.RouteBicycleHiking,
  Tables.OsmHighwayLinestring.Handler,
  OpenMapTilesProfile.FeaturePostProcessor,
  OpenMapTilesProfile.OsmRelationPreprocessor {
  private static final String LAYER_NAME = "route_bicycle_hiking";
  private final Map<String, Integer> NETWORKS = Map.ofEntries(
    entry("icn", 1),
    entry("ncn", 2),
    entry("rcn", 3),
    entry("lcn", 4),
    entry("iwn", 1),
    entry("nwn", 2),
    entry("rwn", 3),
    entry("lwn", 4));
  private static final ZoomFunction.MeterToPixelThresholds MIN_LENGTH = ZoomFunction.meterThresholds()
    .put(7, 50)
    .put(6, 100)
    .put(5, 500)
    .put(4, 1_000);
  private final PlanetilerConfig config;

  public RouteBicycleHiking(Translations translations, PlanetilerConfig config, Stats stats) {
    this.config = config;
  }

  @Override
  public String name() {
    return LAYER_NAME;
  }

  List<RouteRelation> getRouteRelations(Tables.OsmHighwayLinestring element) {
    List<OsmReader.RelationMember<RouteRelation>> relations = element.source().relationInfo(RouteRelation.class);
    List<RouteRelation> result = new ArrayList<>(relations.size() + 1);
    for (var relationMember : relations) {
      var relation = relationMember.relation();
      // avoid duplicates - list should be very small and usually only one
      if (!result.contains(relation)) {
        result.add(relation);
      }
    }
    Collections.sort(result);
    return result;
  }

  RouteRelation getRouteRelation(Tables.OsmHighwayLinestring element) {
    List<RouteRelation> all = getRouteRelations(element);
    return all.isEmpty() ? null : all.get(0);
  }

  @Override
  public void process(Tables.OsmHighwayLinestring element, FeatureCollector features) {
    if (element.isArea()) {
      return;
    }

    RouteRelation routeRelation = getRouteRelation(element);
    if (routeRelation != null) {
      boolean isBicycle = routeRelation.isBicycle();
      features.line(LAYER_NAME)
        .setBufferPixels(4)
        .setMinPixelSize(0) // merge during post-processing, then limit by size
        .setMinZoom(4)
        .setAttr("bicycle_network", isBicycle ? routeRelation.network() : null)
        .setAttr("bicycle_name", isBicycle ? element.source().getTag("name") : null)
        .setAttr("bicycle_ref", isBicycle ? element.source().getTag("ref") : null)
        .setAttr("hiking_network", isBicycle ? null : routeRelation.network())
        .setAttr("hiking_name", isBicycle ? null : element.source().getTag("name"))
        .setAttr("hiking_ref", isBicycle ? null : element.source().getTag("ref"));
    }
  }

  @Override
  public List<OsmRelationInfo> preprocessOsmRelation(OsmElement.Relation relation) {
    if (relation.hasTag("route", "bicycle", "hiking") &&
      relation.hasTag("network", "icn", "ncn", "rcn", "lcn", "iwn", "nwn", "rwn", "lwn")) {
      String network = relation.getString("network");
      Integer networkLevel = NETWORKS.get(network);

      if (networkLevel != null) {
        return List.of(new RouteRelation(
          relation.id(),
          relation.getString("route").equals("bicycle"),
          networkLevel,
          relation.getString("name"),
          relation.getString("ref")));
      }
    }
    return null;
  }

  @Override
  public List<VectorTile.Feature> postProcess(int zoom, List<VectorTile.Feature> items) {
    double tolerance = config.tolerance(zoom);
    double minLength = coalesce(MIN_LENGTH.apply(zoom), 0).doubleValue();
    return FeatureMerge.mergeLineStrings(items, minLength, tolerance, BUFFER_SIZE);
  }

  // ORDER BY route, network, LENGTH(ref), ref)
  private static final Comparator<RouteRelation> RELATION_ORDERING = Comparator
    .<RouteRelation, Boolean>comparing(r -> !r.isBicycle())
    .thenComparingInt(r -> r.network())
    .thenComparingInt(r -> r.ref() != null ? r.ref().length() : Integer.MAX_VALUE)
    .thenComparing(r -> r.ref() != null ? r.ref() : "zzzzzz");

  /**
   * Information extracted from route relations to use when processing ways in that relation.
   */
  record RouteRelation(@Override long id,
    Boolean isBicycle,
    Integer network,
    String name,
    String ref) implements OsmRelationInfo, Comparable<RouteRelation> {

    @Override
    public long estimateMemoryUsageBytes() {
      return CLASS_HEADER_BYTES +
        POINTER_BYTES + estimateSize(isBicycle) +
        POINTER_BYTES + INT_BYTES +
        POINTER_BYTES + estimateSize(name) +
        POINTER_BYTES + estimateSize(ref) +
        MemoryEstimator.estimateSizeLong(id);
    }

    @Override
    public int compareTo(RouteRelation o) {
      return RELATION_ORDERING.compare(this, o);
    }
  }
}
