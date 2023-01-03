package org.openmaptiles.layers;

import static java.util.Map.entry;
import static org.openmaptiles.util.Utils.*;

import com.onthegomap.planetiler.FeatureCollector;
import com.onthegomap.planetiler.FeatureMerge;
import com.onthegomap.planetiler.VectorTile;
import com.onthegomap.planetiler.config.PlanetilerConfig;
import com.onthegomap.planetiler.stats.Stats;
import com.onthegomap.planetiler.util.Translations;
import com.onthegomap.planetiler.util.ZoomFunction;
import java.util.List;
import java.util.Map;
import org.openmaptiles.OpenMapTilesProfile;
import org.openmaptiles.generated.OpenMapTilesSchema;
import org.openmaptiles.generated.Tables;

public class TransportationBicycle implements
  OpenMapTilesSchema.TransportationBicycle,
  Tables.OsmHighwayBicycle.Handler,
  OpenMapTilesProfile.FeaturePostProcessor {
  private static final String LAYER_NAME = "transportation_bicycle";
  private static final ZoomFunction.MeterToPixelThresholds MIN_LENGTH = ZoomFunction.meterThresholds()
    .put(7, 50)
    .put(6, 100)
    .put(5, 500)
    .put(4, 1_000);

  private static final Map<String, String> CYCLEWAY_FACILITY = Map.ofEntries(
    entry("lane", "lane"),
    entry("shared_lane", "lane"),
    entry("opposite_lane", "lane"),
    entry("track", "track"),
    entry("separate", "track"),
    entry("sidepath", "track"),
    entry("opposite_track", "track"),
    entry("shoulder", "track"),
    entry("share_busway", "busway"),
    entry("opposite_share_busway", "busway"));

  private static final Map<String, Number> CYCLEWAY_ACCESS = Map.ofEntries(
    entry("lane", 1),
    entry("shared_lane", 1),
    entry("track", 1),
    entry("separate", 1),
    entry("sidepath", 1),
    entry("shoulder", 1),
    entry("share_busway", 1),
    entry("opposite_lane", -1),
    entry("opposite", -1),
    entry("opposite_track", -1),
    entry("opposite_share_busway", -1));

  private final PlanetilerConfig config;

  public TransportationBicycle(Translations translations, PlanetilerConfig config, Stats stats) {
    this.config = config;
  }

  @Override
  public String name() {
    return LAYER_NAME;
  }

  @Override
  public void process(Tables.OsmHighwayBicycle element, FeatureCollector features) {
    if (element.highway().equals("cycleway")) {
      features.line(LAYER_NAME)
        .setBufferPixels(16)
        .setMinPixelSize(0) // merge during post-processing, then limit by size
        .setMinZoom(4)
        .setAttr("facility", "cycleway")
        .setAttr("access",
          (element.oneway() != null && element.oneway().equals("yes")) ||
            (element.junction() != null && element.junction().equals("roundabout")) ? "cycleway" : null);

    } else {
      String way = element.cyclewayBoth() != null ? element.cyclewayBoth() : element.cycleway();
      Boolean oneWay = ((element.oneway() != null && element.oneway().equals("yes")) ||
        (element.junction() != null && element.junction().equals("roundabout"))) &&
        !(element.onewayBicycle() != null && element.onewayBicycle().equals("no"));

      List<String> HIGHWAY_BY_FOOT = List.of("pedestrian", "path", "footway");
      List<String> BICYCLE_ACCESS = List.of("yes", "designated");
      Boolean hasDefault = (!HIGHWAY_BY_FOOT.contains(element.highway()) ||
        (element.bicycle() != null && BICYCLE_ACCESS.contains(element.bicycle()))) &&
        (!element.highway().equals("steps") || (element.rampBicycle() != null && element.rampBicycle().equals("yes")));

      // Left
      String facilityLeft = null;
      Number accessLeft = null;

      String cyclewayLeft = element.cyclewayLeft();
      if (cyclewayLeft != null) {
        facilityLeft = CYCLEWAY_FACILITY.get(cyclewayLeft);
      }

      if (facilityLeft == null && way != null) {
        if (oneWay) {
          facilityLeft = Map.ofEntries(
            entry("opposite_lane", "lane"),
            entry("opposite_track", "track"),
            entry("opposite_share_busway", "busway")).get(way);
        } else {
          facilityLeft = Map.ofEntries(
            entry("lane", "lane"),
            entry("shared_lane", "lane"),
            entry("opposite_lane", "lane"),
            entry("track", "track"),
            entry("separate", "track"),
            entry("sidepath", "track"),
            entry("opposite_track", "track"),
            entry("shoulder", "track"),
            entry("share_busway", "busway"),
            entry("opposite_share_busway", "busway")).get(way);
        }
      }

      if (facilityLeft == null && hasDefault) {
        if (!oneWay) {
          if (HIGHWAY_BY_FOOT.contains(element.highway())) {
            facilityLeft = "pedestrian";
          }
        }
      }

      if (cyclewayLeft != null) {
        accessLeft = CYCLEWAY_ACCESS.get(cyclewayLeft);
      }

      if (accessLeft == null && way != null) {
        if (oneWay) {
          accessLeft = Map.ofEntries(
            entry("opposite_lane", -1),
            entry("opposite", -1),
            entry("opposite_track", -1),
            entry("opposite_share_busway", -1)).get(way);
        } else {
          accessLeft = Map.ofEntries(
            entry("lane", -1),
            entry("shared_lane", -1),
            entry("track", -1),
            entry("separate", -1),
            entry("sidepath", -1),
            entry("shoulder", -1),
            entry("share_busway", -1),
            // opposite_* make no sens, use -1
            entry("opposite_lane", -1),
            entry("opposite", -1),
            entry("opposite_track", -1),
            entry("opposite_share_busway", -1)).get(way);
        }
      }

      if (accessLeft == null && hasDefault) {
        if (oneWay) {
          accessLeft = 0;
        } else {
          accessLeft = -1;
        }
      }

      // Right
      String facilityRight = null;
      Number accessRight = null;

      String cyclewayRight = element.cyclewayRight();
      if (cyclewayRight != null) {
        facilityRight = CYCLEWAY_FACILITY.get(cyclewayRight);
      }

      if (facilityRight == null && way != null) {
        facilityRight = Map.ofEntries(
          entry("lane", "lane"),
          entry("shared_lane", "lane"),
          entry("track", "track"),
          entry("separate", "track"),
          entry("sidepath", "track"),
          entry("shoulder", "track"),
          entry("share_busway", "busway")).get(way);
      }

      if (facilityRight == null && hasDefault) {
        if (HIGHWAY_BY_FOOT.contains(element.highway())) {
          facilityRight = "pedestrian";
        }
      }

      if (cyclewayRight != null) {
        accessRight = CYCLEWAY_ACCESS.get(cyclewayRight);
      }

      if (accessRight == null && way != null) {
        accessRight = Map.ofEntries(
          entry("lane", 1),
          entry("shared_lane", 1),
          entry("track", 1),
          entry("separate", 1),
          entry("sidepath", 1),
          entry("shoulder", 1),
          entry("share_busway", 1)).get(way);
      }

      if (accessRight == null && hasDefault) {
        accessRight = 1;
      }

      if (facilityLeft != null || facilityRight != null) {
        features.line(LAYER_NAME)
          .setBufferPixels(16)
          .setMinPixelSize(0) // merge during post-processing, then limit by size
          .setMinZoom(4)
          .setAttr("highway", element.highway())
          .setAttr("facility_left", facilityLeft)
          .setAttr("access_left", accessLeft)
          .setAttr("facility_right", facilityRight)
          .setAttr("access_right", accessRight);
      }
    }
  }

  @Override
  public List<VectorTile.Feature> postProcess(int zoom, List<VectorTile.Feature> items) {
    double tolerance = config.tolerance(zoom);
    double minLength = coalesce(MIN_LENGTH.apply(zoom), 0).doubleValue();
    return FeatureMerge.mergeLineStrings(items, minLength, tolerance, BUFFER_SIZE);
  }
}
