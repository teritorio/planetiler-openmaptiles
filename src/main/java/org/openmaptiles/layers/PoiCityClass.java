package org.openmaptiles.layers;

import static com.onthegomap.planetiler.expression.Expression.*;

import com.onthegomap.planetiler.expression.MultiExpression;
import java.util.Arrays;

public class PoiCityClass {
  record PoiClass(
    String superclass,
    String class_,
    String subclass,
    int zoom,
    char style,
    int priority) {}

  static MultiExpression.Entry[] POI_CLASS_ENTRIES = {
    MultiExpression.entry(
      new PoiClass("amenity", "atm", null, 17, '•', 700),
      matchAny("amenity", "atm")),
    MultiExpression.entry(
      new PoiClass("amenity", "bench", null, 17, '•', 1000),
      matchAny("amenity", "bench")),
    MultiExpression.entry(
      new PoiClass("amenity", "local_communication", "advertising_board", 17, '•', 1000),
      and(matchAny("man_made", "advertising"), matchAny("advertising", "board"))),
    MultiExpression.entry(
      new PoiClass("amenity", "local_communication", "board_map", 17, '•', 500),
      and(matchAny("tourism", "information"), matchAny("information:board", "map"))),
    MultiExpression.entry(
      new PoiClass("amenity", "local_communication", "polling_station", 16, '•', 1000),
      matchAny("amenity", "polling_station")),
    MultiExpression.entry(
      new PoiClass("amenity", "local_communication", "post_box", 17, '•', 1000),
      matchAny("amenity", "post_box")),
    MultiExpression.entry(
      new PoiClass("amenity", "local_communication", "telephone", 17, '•', 1000),
      matchAny("amenity", "telephone")),
    MultiExpression.entry(
      new PoiClass("amenity", "local_communication", "tourism_information_terminal", 17, '•', 1000),
      and(matchAny("tourism", "information"), matchAny("information", "terminal"))),
    MultiExpression.entry(
      new PoiClass("amenity", "sanitary", "drinking_water", 16, '◯', 300),
      matchAny("amenity", "drinking_water")),
    MultiExpression.entry(
      new PoiClass("amenity", "sanitary", "shower", 17, '•', 1000),
      matchAny("amenity", "shower")),
    MultiExpression.entry(
      new PoiClass("amenity", "sanitary", "toilets", 17, '◯', 500),
      and(matchAny("amenity", "toilets"), not(matchAny("access", "no", "private")))),
    MultiExpression.entry(
      new PoiClass("amenity", "stile", null, 17, '•', 1000),
      matchAny("barrier", "stile")),
    MultiExpression.entry(
      new PoiClass("amenity", "ticket", null, 17, '⬤', 700),
      matchAny("shop", "ticket")),
    MultiExpression.entry(
      new PoiClass("amenity", "waste", "container", 17, '•', 800),
      and(matchAny("recycling_type", "container"), matchAny("amenity", "recycling"))),
    MultiExpression.entry(
      new PoiClass("amenity", "waste", "dog_excrement", 17, '•', 1000),
      and(matchAny("waste", "dog_excrement"), matchAny("amenity", "waste_basket"))),
    MultiExpression.entry(
      new PoiClass("amenity", "waste", "recycling_centre", 16, '⬤', 300),
      and(matchAny("recycling_type", "centre"), matchAny("amenity", "recycling"))),
    MultiExpression.entry(
      new PoiClass("amenity", "waste", "sanitary_dump_station", 17, '⬤', 800),
      matchAny("amenity", "sanitary_dump_station")),
    MultiExpression.entry(
      new PoiClass("amenity", "waste", "vending_machine", 17, '•', 1000),
      and(matchAny("amenity", "vending_machine"), matchAny("vending", "excrement_bags"))),
    MultiExpression.entry(
      new PoiClass("amenity", "waste", "waste_basket", 17, '•', 1000),
      matchAny("amenity", "waste_basket")),
    MultiExpression.entry(
      new PoiClass("amenity", "waste", "waste_disposal", 17, '•', 1000),
      matchAny("amenity", "waste_disposal")),
    MultiExpression.entry(
      new PoiClass("catering", "catering_drink", "bar", 17, '⬤', 300),
      matchAny("amenity", "bar")),
    MultiExpression.entry(
      new PoiClass("catering", "catering_drink", "cafe", 17, '⬤', 300),
      matchAny("amenity", "cafe")),
    MultiExpression.entry(
      new PoiClass("catering", "catering_drink", "pub", 17, '⬤', 200),
      matchAny("amenity", "pub")),
    MultiExpression.entry(
      new PoiClass("catering", "catering_food", "caterer", 17, '⬤', 500),
      matchAny("craft", "caterer")),
    MultiExpression.entry(
      new PoiClass("catering", "catering_food", "fast_food", 17, '⬤', 300),
      matchAny("amenity", "fast_food")),
    MultiExpression.entry(
      new PoiClass("catering", "catering_food", "food_court", 17, '⬤', 800),
      matchAny("amenity", "food_court")),
    MultiExpression.entry(
      new PoiClass("catering", "catering_food", "ice_cream", 17, '⬤', 500),
      matchAny("amenity", "ice_cream")),
    MultiExpression.entry(
      new PoiClass("catering", "catering_food", "pastry", 17, '⬤', 200),
      matchAny("shop", "pastry")),
    MultiExpression.entry(
      new PoiClass("catering", "catering_food", "restaurant", 16, '⬤', 200),
      matchAny("amenity", "restaurant")),
    MultiExpression.entry(
      new PoiClass("craft", "basket_maker", null, 17, '⬤', 500),
      matchAny("craft", "basket_maker")),
    MultiExpression.entry(
      new PoiClass("craft", "dressmaker", null, 17, '⬤', 500),
      matchAny("craft", "dressmaker")),
    MultiExpression.entry(
      new PoiClass("craft", "handicraft", null, 17, '⬤', 500),
      matchAny("craft", "handicraft")),
    MultiExpression.entry(
      new PoiClass("craft", "jeweller", null, 17, '⬤', 500),
      matchAny("craft", "jeweller")),
    MultiExpression.entry(
      new PoiClass("craft", "leather", null, 17, '⬤', 500),
      matchAny("craft", "leather")),
    MultiExpression.entry(
      new PoiClass("craft", "luthier", null, 17, '⬤', 500),
      matchAny("craft", "luthier")),
    MultiExpression.entry(
      new PoiClass("craft", "photographer", null, 17, '⬤', 500),
      matchAny("craft", "photographer")),
    MultiExpression.entry(
      new PoiClass("craft", "pottery", null, 17, '⬤', 500),
      matchAny("craft", "pottery")),
    MultiExpression.entry(
      new PoiClass("craft", "sculptor", null, 17, '⬤', 500),
      matchAny("craft", "sculptor")),
    MultiExpression.entry(
      new PoiClass("craft", "shoemaker", null, 17, '⬤', 500),
      matchAny("craft", "shoemaker")),
    MultiExpression.entry(
      new PoiClass("culture", "artwork", null, 17, '•', 800),
      matchAny("tourism", "artwork")),
    MultiExpression.entry(
      new PoiClass("culture", "heritage", "archaeological_site", 14, '•', 30),
      matchAny("historic", "archaeological_site")),
    MultiExpression.entry(
      new PoiClass("culture", "heritage", "castle", 14, '⬤', 30),
      matchAny("historic", "castle")),
    MultiExpression.entry(
      new PoiClass("culture", "heritage", "castle_wall", 14, '•', 800),
      matchAny("historic", "castle_wall")),
    MultiExpression.entry(
      new PoiClass("culture", "heritage", "church_heritage", 14, '•', 800),
      matchAny("historic", "church")),
    MultiExpression.entry(
      new PoiClass("culture", "heritage", "city_gate", 14, '•', 800),
      matchAny("historic", "city_gate")),
    MultiExpression.entry(
      new PoiClass("culture", "heritage", "city_wall", 14, '•', 800),
      matchAny("barrier", "city_wall")),
    MultiExpression.entry(
      new PoiClass("culture", "heritage", "lavoir", 17, '⬤', 800),
      matchAny("amenity", "lavoir")),
    MultiExpression.entry(
      new PoiClass("culture", "heritage", "memorial", 17, '•', 800),
      matchAny("historic", "memorial")),
    MultiExpression.entry(
      new PoiClass("culture", "heritage", "monument", 16, '⬤', 30),
      matchAny("historic", "monument")),
    MultiExpression.entry(
      new PoiClass("culture", "heritage", "wayside_cross", 18, '•', 800),
      matchAny("historic", "wayside_cross")),
    MultiExpression.entry(
      new PoiClass("culture", "heritage", "wayside_shrine", 18, '•', 800),
      matchAny("historic", "wayside_shrine")),
    MultiExpression.entry(
      new PoiClass("culture", "library", null, 14, '⬤', 100),
      matchAny("amenity", "library")),
    MultiExpression.entry(
      new PoiClass("culture", "public_bookcase", null, 17, '⬤', 800),
      matchAny("amenity", "public_bookcase")),
    MultiExpression.entry(
      new PoiClass("culture", "show", "cinema", 15, '⬤', 100),
      matchAny("amenity", "cinema")),
    MultiExpression.entry(
      new PoiClass("culture", "show", "gallery", 17, '⬤', 100),
      matchAny("tourism", "gallery")),
    MultiExpression.entry(
      new PoiClass("culture", "show", "theatre", 14, '⬤', 100),
      matchAny("amenity", "theatre")),
    MultiExpression.entry(
      new PoiClass("culture", "visit", "arts_centre", 16, '⬤', 30),
      matchAny("amenity", "arts_centre")),
    MultiExpression.entry(
      new PoiClass("culture", "visit", "cathedral", 13, '⬤', 30),
      matchAny("building", "cathedral")),
    MultiExpression.entry(
      new PoiClass("culture", "visit", "chapel", 17, '•', 30),
      matchAny("building", "chapel")),
    MultiExpression.entry(
      new PoiClass("culture", "visit", "church", 15, '⬤', 30),
      matchAny("building", "church")),
    MultiExpression.entry(
      new PoiClass("culture", "visit", "monastery", 16, '⬤', 30),
      matchAny("amenity", "monastery")),
    MultiExpression.entry(
      new PoiClass("culture", "visit", "museum", 14, '⬤', 0),
      matchAny("tourism", "museum")),
    MultiExpression.entry(
      new PoiClass("culture", "visit", "place_of_worship", 17, '•', 40),
      matchAny("amenity", "place_of_worship")),
    MultiExpression.entry(
      new PoiClass("culture_shopping", "antiques", null, 17, '⬤', 600),
      matchAny("shop", "antiques")),
    MultiExpression.entry(
      new PoiClass("culture_shopping", "art", null, 17, '⬤', 600),
      matchAny("shop", "art")),
    MultiExpression.entry(
      new PoiClass("culture_shopping", "books", null, 16, '⬤', 600),
      matchAny("shop", "books")),
    MultiExpression.entry(
      new PoiClass("culture_shopping", "music", null, 16, '⬤', 600),
      matchAny("shop", "music")),
    MultiExpression.entry(
      new PoiClass("culture_shopping", "photo", null, 17, '⬤', 500),
      matchAny("shop", "photo")),
    MultiExpression.entry(
      new PoiClass("education", "college", null, 16, '⬤', 100),
      matchAny("amenity", "college")),
    MultiExpression.entry(
      new PoiClass("education", "education_early_childhood", "kindergarten", 16, '⬤', 100),
      matchAny("amenity", "kindergarten")),
    MultiExpression.entry(
      new PoiClass("education", "education_youth", "child_youth_centre", 16, '⬤', 100),
      and(matchAny("amenity", "community_centre"), matchAny("community_centre:for", "child"))),
    MultiExpression.entry(
      new PoiClass("education", "education_youth", "juvenile_youth_centre", 16, '⬤', 100),
      and(matchAny("amenity", "community_centre"), matchAny("community_centre:for", "juvenile"))),
    MultiExpression.entry(
      new PoiClass("education", "lower_secondary_education", null, 16, '⬤', 100),
      and(matchAny("amenity", "school"), matchAny("school:FR", "collège"))),
    MultiExpression.entry(
      new PoiClass("education", "pre_primary_school", null, 16, '⬤', 100),
      and(matchAny("amenity", "school"), matchAny("school:FR", "maternelle"))),
    MultiExpression.entry(
      new PoiClass("education", "primary_education", null, 16, '⬤', 101),
      matchAny("amenity", "school")),
    MultiExpression.entry(
      new PoiClass("education", "university", null, 13, '⬤', 100),
      matchAny("amenity", "university")),
    MultiExpression.entry(
      new PoiClass("education", "upper_secondary_education", null, 16, '⬤', 100),
      and(matchAny("amenity", "school"), matchAny("school:FR", "lycée"))),
    MultiExpression.entry(
      new PoiClass("hosting", "hosting_hotel", "animal_boarding", 17, '⬤', 300),
      matchAny("amenity", "animal_boarding")),
    MultiExpression.entry(
      new PoiClass("hosting", "hosting_hotel", "guest_house", 17, '⬤', 300),
      matchAny("tourism", "guest_house")),
    MultiExpression.entry(
      new PoiClass("hosting", "hosting_hotel", "hostel", 17, '⬤', 300),
      matchAny("tourism", "hostel")),
    MultiExpression.entry(
      new PoiClass("hosting", "hosting_hotel", "hotel", 17, '⬤', 300),
      matchAny("tourism", "hotel")),
    MultiExpression.entry(
      new PoiClass("hosting", "hosting_hotel", "motel", 17, '⬤', 300),
      matchAny("tourism", "motel")),
    MultiExpression.entry(
      new PoiClass("hosting", "hosting_rental", "apartment_rental", 18, '•', 500),
      matchAny("tourism", "apartment")),
    MultiExpression.entry(
      new PoiClass("hosting", "hosting_rental", "chalet", 17, '⬤', 500),
      matchAny("tourism", "chalet")),
    MultiExpression.entry(
      new PoiClass("hosting", "hosting_resort", "apartment_resort", 17, '⬤', 300),
      matchAny("tourism", "apartment")),
    MultiExpression.entry(
      new PoiClass("hosting", "hosting_resort", "camp_site", 16, '⬤', 200),
      matchAny("tourism", "camp_site")),
    MultiExpression.entry(
      new PoiClass("hosting", "hosting_resort", "caravan_site", 17, '⬤', 800),
      matchAny("tourism", "caravan_site")),
    MultiExpression.entry(
      new PoiClass("hosting", "hosting_resort", "resort", 16, '⬤', 500),
      matchAny("leisure", "resort")),
    MultiExpression.entry(
      new PoiClass("leisure", "bowling_alley", null, 16, '⬤', 200),
      matchAny("leisure", "bowling_alley")),
    MultiExpression.entry(
      new PoiClass("leisure", "casino", null, 16, '⬤', 200),
      matchAny("amenity", "casino")),
    MultiExpression.entry(
      new PoiClass("leisure", "community_centre", null, 17, '⬤', 500),
      matchAny("amenity", "community_centre")),
    MultiExpression.entry(
      new PoiClass("leisure", "dojo", null, 17, '•', 500),
      matchAny("amenity", "dojo")),
    MultiExpression.entry(
      new PoiClass("leisure", "fitness_centre", null, 17, '⬤', 500),
      matchAny("leisure", "fitness_centre")),
    MultiExpression.entry(
      new PoiClass("leisure", "golf_course", null, 15, '⬤', 200),
      and(matchAny("leisure", "golf_course"), and(matchField("name"), not(matchAny("name", "no"))))),
    MultiExpression.entry(
      new PoiClass("leisure", "golf_course_minor", null, 16, '•', 300),
      matchAny("leisure", "golf_course")),
    MultiExpression.entry(
      new PoiClass("leisure", "horse_riding", null, 16, '⬤', 200),
      matchAny("leisure", "horse_riding")),
    MultiExpression.entry(
      new PoiClass("leisure", "hut", "alpine_hut", 16, '⬤', 300),
      matchAny("tourism", "alpine_hut")),
    MultiExpression.entry(
      new PoiClass("leisure", "hut", "shelter", 17, '•', 100),
      matchAny("amenity", "shelter")),
    MultiExpression.entry(
      new PoiClass("leisure", "hut", "wilderness_hut", 17, '⬤', 800),
      matchAny("tourism", "wilderness_hut")),
    MultiExpression.entry(
      new PoiClass("leisure", "ice_rink", null, 15, '⬤', 200),
      matchAny("leisure", "ice_rink")),
    MultiExpression.entry(
      new PoiClass("leisure", "miniature_golf", null, 17, '⬤', 200),
      matchAny("leisure", "miniature_golf")),
    MultiExpression.entry(
      new PoiClass("leisure", "nightclub", null, 17, '⬤', 200),
      matchAny("amenity", "nightclub")),
    MultiExpression.entry(
      new PoiClass("leisure", "picnic", "bbq", 17, '•', 1000),
      matchAny("amenity", "bbq")),
    MultiExpression.entry(
      new PoiClass("leisure", "picnic", "firepit", 17, '•', 1000),
      matchAny("leisure", "firepit")),
    MultiExpression.entry(
      new PoiClass("leisure", "picnic", "picnic_site", 17, '⬤', 500),
      matchAny("tourism", "picnic_site")),
    MultiExpression.entry(
      new PoiClass("leisure", "picnic", "picnic_table", 17, '•', 1000),
      matchAny("leisure", "picnic_table")),
    MultiExpression.entry(
      new PoiClass("leisure", "pitch", null, 17, '•', 501),
      matchAny("leisure", "pitch")),
    MultiExpression.entry(
      new PoiClass("leisure", "playground", null, 17, '⬤', 500),
      matchAny("leisure", "playground")),
    MultiExpression.entry(
      new PoiClass("leisure", "public_bath", null, 15, '⬤', 200),
      and(matchAny("amenity", "public_bath"), matchAny("bath:type", "thermal"))),
    MultiExpression.entry(
      new PoiClass("leisure", "sport_practice", "athletics", 17, '•', 500),
      matchAny("sport", "athletics")),
    MultiExpression.entry(
      new PoiClass("leisure", "sport_practice", "badminton", 17, '•', 500),
      matchAny("sport", "badminton")),
    MultiExpression.entry(
      new PoiClass("leisure", "sport_practice", "basketball", 17, '•', 500),
      and(matchAny("sport", "basketball"), matchAny("leisure", "pitch"))),
    MultiExpression.entry(
      new PoiClass("leisure", "sport_practice", "beachvolleyball", 17, '•', 500),
      and(matchAny("sport", "beachvolleyball"), matchAny("leisure", "pitch"))),
    MultiExpression.entry(
      new PoiClass("leisure", "sport_practice", "billiards", 17, '⬤', 500),
      matchAny("sport", "billiards")),
    MultiExpression.entry(
      new PoiClass("leisure", "sport_practice", "bmx", 17, '•', 500),
      matchAny("sport", "bmx")),
    MultiExpression.entry(
      new PoiClass("leisure", "sport_practice", "boules", 16, '⬤', 500),
      and(matchAny("sport", "boules"), matchAny("leisure", "pitch"))),
    MultiExpression.entry(
      new PoiClass("leisure", "sport_practice", "bullfighting", 17, '⬤', 500),
      and(matchAny("sport", "bullfighting"), matchAny("leisure", "pitch"))),
    MultiExpression.entry(
      new PoiClass("leisure", "sport_practice", "canoe", 17, '•', 300),
      matchAny("sport", "canoe")),
    MultiExpression.entry(
      new PoiClass("leisure", "sport_practice", "climbing", 17, '•', 500),
      matchAny("sport", "climbing")),
    MultiExpression.entry(
      new PoiClass("leisure", "sport_practice", "climbing_adventure", 17, '⬤', 500),
      and(matchAny("sport", "climbing_adventure"), matchAny("leisure", "pitch"))),
    MultiExpression.entry(
      new PoiClass("leisure", "sport_practice", "cycling", 14, '•', 500),
      matchAny("sport", "cycling")),
    MultiExpression.entry(
      new PoiClass("leisure", "sport_practice", "diving", 17, '•', 500),
      matchAny("sport", "diving")),
    MultiExpression.entry(
      new PoiClass("leisure", "sport_practice", "free_flying", 17, '•', 500),
      matchAny("sport", "free_flying")),
    MultiExpression.entry(
      new PoiClass("leisure", "sport_practice", "futsal", 16, '•', 500),
      matchAny("sport", "futsal")),
    MultiExpression.entry(
      new PoiClass("leisure", "sport_practice", "gymnastics", 17, '•', 500),
      matchAny("sport", "gymnastics")),
    MultiExpression.entry(
      new PoiClass("leisure", "sport_practice", "handball", 17, '•', 500),
      and(matchAny("sport", "handball"), matchAny("leisure", "pitch"))),
    MultiExpression.entry(
      new PoiClass("leisure", "sport_practice", "horse_racing", 14, '•', 500),
      matchAny("sport", "horse_racing")),
    MultiExpression.entry(
      new PoiClass("leisure", "sport_practice", "ice_hockey", 17, '•', 500),
      matchAny("sport", "ice_hockey")),
    MultiExpression.entry(
      new PoiClass("leisure", "sport_practice", "karting", 17, '⬤', 500),
      and(matchAny("sport", "karting"), matchAny("leisure", "pitch"))),
    MultiExpression.entry(
      new PoiClass("leisure", "sport_practice", "kitesurfing", 17, '•', 500),
      matchAny("sport", "kitesurfing")),
    MultiExpression.entry(
      new PoiClass("leisure", "sport_practice", "motocross", 17, '•', 500),
      matchAny("sport", "motocross")),
    MultiExpression.entry(
      new PoiClass("leisure", "sport_practice", "motor", 17, '•', 500),
      matchAny("sport", "motor")),
    MultiExpression.entry(
      new PoiClass("leisure", "sport_practice", "multi", 16, '•', 500),
      and(matchAny("sport", "multi"), matchAny("leisure", "pitch"))),
    MultiExpression.entry(
      new PoiClass("leisure", "sport_practice", "orienteering", 17, '•', 500),
      matchAny("sport", "orienteering")),
    MultiExpression.entry(
      new PoiClass("leisure", "sport_practice", "paddle_tennis", 17, '•', 500),
      matchAny("sport", "paddle_tennis")),
    MultiExpression.entry(
      new PoiClass("leisure", "sport_practice", "paintball", 14, '•', 500),
      matchAny("sport", "paintball")),
    MultiExpression.entry(
      new PoiClass("leisure", "sport_practice", "pelota", 17, '⬤', 500),
      and(matchAny("sport", "pelota"), matchAny("leisure", "pitch"))),
    MultiExpression.entry(
      new PoiClass("leisure", "sport_practice", "racquet", 17, '•', 500),
      matchAny("sport", "racquet")),
    MultiExpression.entry(
      new PoiClass("leisure", "sport_practice", "rowing", 17, '•', 500),
      matchAny("sport", "rowing")),
    MultiExpression.entry(
      new PoiClass("leisure", "sport_practice", "rugby", 17, '•', 500),
      matchAny("sport", "rugby")),
    MultiExpression.entry(
      new PoiClass("leisure", "sport_practice", "rugby_league", 17, '•', 500),
      matchAny("sport", "rugby_league")),
    MultiExpression.entry(
      new PoiClass("leisure", "sport_practice", "rugby_union", 17, '•', 500),
      matchAny("sport", "rugby_union")),
    MultiExpression.entry(
      new PoiClass("leisure", "sport_practice", "running", 17, '•', 500),
      matchAny("sport", "running")),
    MultiExpression.entry(
      new PoiClass("leisure", "sport_practice", "sailing", 15, '•', 300),
      matchAny("sport", "sailing")),
    MultiExpression.entry(
      new PoiClass("leisure", "sport_practice", "scuba_diving", 14, '•', 500),
      matchAny("sport", "scuba_diving")),
    MultiExpression.entry(
      new PoiClass("leisure", "sport_practice", "shooting", 17, '•', 500),
      matchAny("sport", "shooting")),
    MultiExpression.entry(
      new PoiClass("leisure", "sport_practice", "skateboard", 16, '•', 500),
      and(matchAny("sport", "skateboard"), matchAny("leisure", "pitch"))),
    MultiExpression.entry(
      new PoiClass("leisure", "sport_practice", "soccer", 17, '•', 500),
      matchAny("sport", "soccer")),
    MultiExpression.entry(
      new PoiClass("leisure", "sport_practice", "squash", 17, '•', 500),
      and(matchAny("sport", "squash"), matchAny("leisure", "pitch"))),
    MultiExpression.entry(
      new PoiClass("leisure", "sport_practice", "surfing", 17, '⬤', 500),
      matchAny("sport", "surfing")),
    MultiExpression.entry(
      new PoiClass("leisure", "sport_practice", "swimming", 16, '•', 500),
      matchAny("sport", "swimming")),
    MultiExpression.entry(
      new PoiClass("leisure", "sport_practice", "table_soccer", 17, '•', 500),
      matchAny("sport", "table_soccer")),
    MultiExpression.entry(
      new PoiClass("leisure", "sport_practice", "table_tennis", 17, '•', 500),
      matchAny("sport", "table_tennis")),
    MultiExpression.entry(
      new PoiClass("leisure", "sport_practice", "tennis", 17, '⬤', 500),
      and(matchAny("sport", "tennis"), matchAny("leisure", "pitch"))),
    MultiExpression.entry(
      new PoiClass("leisure", "sport_practice", "volleyball", 17, '•', 500),
      and(matchAny("sport", "volleyball"), matchAny("leisure", "pitch"))),
    MultiExpression.entry(
      new PoiClass("leisure", "sport_practice", "water_ski", 17, '•', 500),
      matchAny("sport", "water_ski")),
    MultiExpression.entry(
      new PoiClass("leisure", "sport_practice", "yoga", 16, '•', 500),
      matchAny("sport", "yoga")),
    MultiExpression.entry(
      new PoiClass("leisure", "sports_centre", null, 16, '⬤', 201),
      matchAny("leisure", "sports_centre")),
    MultiExpression.entry(
      new PoiClass("leisure", "surf_school", null, 17, '⬤', 200),
      matchAny("amenity", "surf_school")),
    MultiExpression.entry(
      new PoiClass("leisure", "swimming_centre", null, 15, '⬤', 200),
      and(matchAny("sport", "swimming"), matchAny("leisure", "sports_centre"))),
    MultiExpression.entry(
      new PoiClass("leisure", "swimming_pool", null, 16, '⬤', 200),
      and(matchAny("leisure", "swimming_pool"), and(matchField("name"), not(matchAny("name", "no"))))),
    MultiExpression.entry(
      new PoiClass("leisure", "trinquete", null, 16, '⬤', 200),
      and(matchAny("sport", "pelota"), matchAny("leisure", "sports_centre"))),
    MultiExpression.entry(
      new PoiClass("local_shop", "alcohol", null, 17, '⬤', 500),
      matchAny("shop", "alcohol")),
    MultiExpression.entry(
      new PoiClass("local_shop", "bakery", null, 16, '⬤', 300),
      matchAny("shop", "bakery")),
    MultiExpression.entry(
      new PoiClass("local_shop", "butcher", null, 16, '⬤', 300),
      matchAny("shop", "butcher")),
    MultiExpression.entry(
      new PoiClass("local_shop", "cheese", null, 17, '⬤', 300),
      matchAny("shop", "cheese")),
    MultiExpression.entry(
      new PoiClass("local_shop", "confectionery", null, 17, '⬤', 400),
      matchAny("shop", "confectionery")),
    MultiExpression.entry(
      new PoiClass("local_shop", "convenience", null, 16, '⬤', 300),
      matchAny("shop", "convenience")),
    MultiExpression.entry(
      new PoiClass("local_shop", "deli", null, 17, '⬤', 300),
      matchAny("shop", "deli")),
    MultiExpression.entry(
      new PoiClass("local_shop", "frozen_food", null, 17, '⬤', 400),
      matchAny("shop", "frozen_food")),
    MultiExpression.entry(
      new PoiClass("local_shop", "greengrocer", null, 17, '⬤', 300),
      matchAny("shop", "greengrocer")),
    MultiExpression.entry(
      new PoiClass("local_shop", "marketplace", null, 14, '⬤', 100),
      matchAny("amenity", "marketplace")),
    MultiExpression.entry(
      new PoiClass("local_shop", "seafood", null, 16, '⬤', 300),
      matchAny("shop", "seafood")),
    MultiExpression.entry(
      new PoiClass("local_shop", "supermarket", null, 16, '⬤', 200),
      matchAny("shop", "supermarket")),
    MultiExpression.entry(
      new PoiClass("mobility", "aeroway", "aerodrome", 11, '⬤', 0),
      and(matchAny("aeroway", "aerodrome"), matchAny("aerodrome", "international"))),
    MultiExpression.entry(
      new PoiClass("mobility", "bicycle", "bicycle_docking_station", 16, '◯', 200),
      matchAny("amenity", "bicycle_rental")),
    MultiExpression.entry(
      new PoiClass("mobility", "bicycle", "bicycle_parking", 17, '◯', 200),
      matchAny("amenity", "bicycle_parking")),
    MultiExpression.entry(
      new PoiClass("mobility", "bicycle", "bicycle_rental", 17, '⬤', 200),
      and(matchAny("shop", "bicycle"), matchAny("service:bicycle:rental", "yes"))),
    MultiExpression.entry(
      new PoiClass("mobility", "bicycle", "compressed_air", 17, '•', 200),
      matchAny("amenity", "compressed_air")),
    MultiExpression.entry(
      new PoiClass("mobility", "bicycle", "cycle_barrier", 17, '•', 200),
      matchAny("barrier", "cycle_barrier")),
    MultiExpression.entry(
      new PoiClass("mobility", "bicycle", "motorcycle_parking", 17, '◯', 200),
      matchAny("amenity", "motorcycle_parking")),
    MultiExpression.entry(
      new PoiClass("mobility", "charging_station", null, 16, '◯', 200),
      and(matchAny("amenity", "charging_station"), matchAny("bycycle", "yes"), matchAny("car", "yes"),
        matchAny("scooter", "yes"))),
    MultiExpression.entry(
      new PoiClass("mobility", "fuel", null, 17, '⬤', 700),
      matchAny("amenity", "fuel")),
    MultiExpression.entry(
      new PoiClass("mobility", "motorway", "bus_station", 15, '⬤', 70),
      matchAny("amenity", "bus_station")),
    MultiExpression.entry(
      new PoiClass("mobility", "motorway", "bus_stop", 17, '◯', 100),
      matchAny("highway", "bus_stop")),
    MultiExpression.entry(
      new PoiClass("mobility", "motorway", "car_pooling", 16, '◯', 200),
      matchAny("amenity", "car_pooling")),
    MultiExpression.entry(
      new PoiClass("mobility", "motorway", "car_rental", 17, '⬤', 500),
      matchAny("amenity", "car_rental")),
    MultiExpression.entry(
      new PoiClass("mobility", "motorway", "motorway_junction", 15, '•', 70),
      and(matchAny("highway", "motorway_junction"), and(matchField("ref"), not(matchAny("ref", "no"))))),
    MultiExpression.entry(
      new PoiClass("mobility", "motorway", "parking", 16, '◯', 200),
      and(matchAny("amenity", "parking"), and(matchField("name"), not(matchAny("name", "no"))))),
    MultiExpression.entry(
      new PoiClass("mobility", "motorway", "taxi", 16, '◯', 70),
      matchAny("amenity", "taxi")),
    MultiExpression.entry(
      new PoiClass("mobility", "motorway", "toll_booth", 15, '•', 70),
      matchAny("barrier", "toll_booth")),
    MultiExpression.entry(
      new PoiClass("mobility", "railway", "halt", 14, '◯', 60),
      matchAny("railway", "halt")),
    MultiExpression.entry(
      new PoiClass("mobility", "railway", "station", 13, '⬤', 60),
      matchAny("railway", "station")),
    MultiExpression.entry(
      new PoiClass("mobility", "railway", "subway_entrance", 16, '◯', 60),
      matchAny("railway", "subway_entrance")),
    MultiExpression.entry(
      new PoiClass("mobility", "railway", "train_station_entrance", 17, '•', 60),
      matchAny("railway", "train_station_entrance")),
    MultiExpression.entry(
      new PoiClass("mobility", "railway", "tram_stop", 16, '◯', 60),
      matchAny("railway", "tram_stop")),
    MultiExpression.entry(
      new PoiClass("mobility", "waterway", "dock", 17, '•', 60),
      matchAny("waterway", "dock")),
    MultiExpression.entry(
      new PoiClass("mobility", "waterway", "ferry_terminal", 15, '⬤', 60),
      matchAny("amenity", "ferry_terminal")),
    MultiExpression.entry(
      new PoiClass("nature", "hide", "bird_hide", 17, '•', 100),
      matchAny("leisure", "bird_hide")),
    MultiExpression.entry(
      new PoiClass("nature", "hide", "tower", 17, '•', 100),
      and(matchAny("man_made", "tower"), matchAny("tower:type", "observation"))),
    MultiExpression.entry(
      new PoiClass("nature", "hide", "wildlife_hide", 17, '•', 100),
      matchAny("leisure", "wildlife_hide")),
    MultiExpression.entry(
      new PoiClass("nature", "park", "garden", 15, '⬤', 200),
      matchAny("leisure", "garden")),
    MultiExpression.entry(
      new PoiClass("nature", "park", "park", 14, '⬤', 100),
      and(matchAny("leisure", "park"), and(matchField("name"), not(matchAny("name", "no"))))),
    MultiExpression.entry(
      new PoiClass("products", "beekeeper", null, 17, '⬤', 500),
      matchAny("craft", "beekeeper")),
    MultiExpression.entry(
      new PoiClass("products", "brewery", null, 16, '⬤', 500),
      matchAny("craft", "brewery")),
    MultiExpression.entry(
      new PoiClass("products", "carpet", null, 17, '⬤', 500),
      matchAny("shop", "carpet")),
    MultiExpression.entry(
      new PoiClass("products", "chocolate", null, 17, '⬤', 500),
      matchAny("shop", "chocolate")),
    MultiExpression.entry(
      new PoiClass("products", "coffee", null, 16, '⬤', 400),
      matchAny("shop", "coffee")),
    MultiExpression.entry(
      new PoiClass("products", "distillery", null, 17, '⬤', 500),
      matchAny("craft", "distillery")),
    MultiExpression.entry(
      new PoiClass("products", "farm", null, 15, '⬤', 200),
      matchAny("shop", "farm")),
    MultiExpression.entry(
      new PoiClass("products", "grinding_mill", null, 17, '⬤', 500),
      matchAny("craft", "grinding_mill")),
    MultiExpression.entry(
      new PoiClass("products", "oil_mill", null, 17, '⬤', 200),
      matchAny("craft", "oil_mill")),
    MultiExpression.entry(
      new PoiClass("products", "tailor", null, 17, '⬤', 500),
      matchAny("shop", "tailor")),
    MultiExpression.entry(
      new PoiClass("products", "winery", null, 16, '⬤', 500),
      matchAny("craft", "winery")),
    MultiExpression.entry(
      new PoiClass("public_landmark", "border_control", null, 16, '•', 100),
      matchAny("barrier", "border_control")),
    MultiExpression.entry(
      new PoiClass("public_landmark", "brownfield", null, 14, '•', 100),
      matchAny("landuse", "brownfield")),
    MultiExpression.entry(
      new PoiClass("public_landmark", "cemetery", null, 14, '•', 100),
      matchAny("landuse", "cemetery")),
    MultiExpression.entry(
      new PoiClass("public_landmark", "embassy", null, 16, '⬤', 100),
      matchAny("amenity", "embassy")),
    MultiExpression.entry(
      new PoiClass("public_landmark", "grave_yard", null, 14, '•', 100),
      matchAny("amenity", "grave_yard")),
    MultiExpression.entry(
      new PoiClass("public_landmark", "mall", null, 14, '⬤', 100),
      matchAny("shop", "mall")),
    MultiExpression.entry(
      new PoiClass("public_landmark", "mountain_pass", null, 13, '•', 100),
      and(matchAny("mountain_pass", "yes"), and(matchField("name"), not(matchAny("name", "no"))))),
    MultiExpression.entry(
      new PoiClass("public_landmark", "prison", null, 16, '•', 100),
      matchAny("amenity", "prison")),
    MultiExpression.entry(
      new PoiClass("remarkable", "attraction_activity", "aquarium", 16, '⬤', 0),
      matchAny("tourism", "aquarium")),
    MultiExpression.entry(
      new PoiClass("remarkable", "attraction_activity", "attraction", 15, '⬤', 0),
      matchAny("tourism", "attraction")),
    MultiExpression.entry(
      new PoiClass("remarkable", "attraction_activity", "cave_entrance", 15, '•', 100),
      and(matchAny("natural", "cave_entrance"), and(matchField("name"), not(matchAny("name", "no"))))),
    MultiExpression.entry(
      new PoiClass("remarkable", "attraction_activity", "lighthouse", 15, '⬤', 500),
      and(matchAny("man_made", "lighthouse"), and(matchField("name"), not(matchAny("name", "no"))))),
    MultiExpression.entry(
      new PoiClass("remarkable", "attraction_activity", "lighthouse_minor", 17, '•', 500),
      matchAny("man_made", "lighthouse")),
    MultiExpression.entry(
      new PoiClass("remarkable", "attraction_activity", "spring", 17, '•', 500),
      matchAny("natural", "spring")),
    MultiExpression.entry(
      new PoiClass("remarkable", "attraction_activity", "theme_park", 16, '⬤', 1),
      matchAny("tourism", "theme_park")),
    MultiExpression.entry(
      new PoiClass("remarkable", "attraction_activity", "viewpoint", 17, '⬤', 500),
      and(matchAny("tourism", "viewpoint"), and(matchField("description"), not(matchAny("description", "no"))))),
    MultiExpression.entry(
      new PoiClass("remarkable", "attraction_activity", "water_park", 16, '⬤', 0),
      matchAny("leisure", "water_park")),
    MultiExpression.entry(
      new PoiClass("remarkable", "attraction_activity", "waterfall", 16, '⬤', 300),
      and(matchAny("waterway", "waterfall"), and(matchField("name"), not(matchAny("name", "no"))))),
    MultiExpression.entry(
      new PoiClass("remarkable", "attraction_activity", "zoo", 16, '⬤', 0),
      matchAny("tourism", "zoo")),
    MultiExpression.entry(
      new PoiClass("remarkable", "commercial_activity", "retail", 15, '⬤', 100),
      and(matchAny("landuse", "retail"), and(matchField("name"), not(matchAny("name", "no"))))),
    MultiExpression.entry(
      new PoiClass("remarkable", "natural_activity", "beach", 16, '⬤', 0),
      and(matchAny("natural", "beach"), and(matchField("name"), not(matchAny("name", "no"))))),
    MultiExpression.entry(
      new PoiClass("remarkable", "natural_activity", "beach_resort", 17, '⬤', 0),
      matchAny("leisure", "beach_resort")),
    MultiExpression.entry(
      new PoiClass("remarkable", "outdoor_activity", "bullring", 14, '⬤', 0),
      and(matchAny("leisure", "stadium"), matchAny("sport", "bullfighting"))),
    MultiExpression.entry(
      new PoiClass("remarkable", "outdoor_activity", "fishing", 14, '⬤', 0),
      matchAny("leisure", "fishing")),
    MultiExpression.entry(
      new PoiClass("remarkable", "outdoor_activity", "marina", 14, '⬤', 0),
      matchAny("leisure", "marina")),
    MultiExpression.entry(
      new PoiClass("remarkable", "outdoor_activity", "stadium", 14, '⬤', 0),
      matchAny("leisure", "stadium")),
    MultiExpression.entry(
      new PoiClass("remarkable", "outdoor_activity", "swimming_area", 16, '⬤', 0),
      matchAny("leisure", "swimming_area")),
    MultiExpression.entry(
      new PoiClass("remarkable", "outdoor_activity", "winter_sports", 17, '⬤', 0),
      matchAny("landuse", "winter_sports")),
    MultiExpression.entry(
      new PoiClass("safety", "care", "animal_shelter", 17, '⬤', 50),
      matchAny("amenity", "animal_shelter")),
    MultiExpression.entry(
      new PoiClass("safety", "care", "dentist", 17, '•', 50),
      matchAny("amenity", "dentist")),
    MultiExpression.entry(
      new PoiClass("safety", "care", "doctors", 17, '•', 50),
      and(matchAny("amenity", "doctors"), matchAny("healthcare:speciality", "general"))),
    MultiExpression.entry(
      new PoiClass("safety", "care", "healthcare_centre", 15, '⬤', 50),
      matchAny("healthcare", "centre")),
    MultiExpression.entry(
      new PoiClass("safety", "care", "nurse", 17, '•', 50),
      matchAny("healthcare", "nurse")),
    MultiExpression.entry(
      new PoiClass("safety", "care", "pharmacy", 16, '⬤', 100),
      matchAny("amenity", "pharmacy")),
    MultiExpression.entry(
      new PoiClass("safety", "care", "physiotherapist", 17, '•', 50),
      matchAny("healthcare", "physiotherapist")),
    MultiExpression.entry(
      new PoiClass("safety", "care", "veterinary", 17, '•', 50),
      matchAny("amenity", "veterinary")),
    MultiExpression.entry(
      new PoiClass("safety", "emergency", "clinic", 13, '⬤', 0),
      and(matchAny("amenity", "clinic"), matchAny("emergency", "yes"))),
    MultiExpression.entry(
      new PoiClass("safety", "emergency", "defibrillator", 17, '⬤', 0),
      matchAny("emergency", "defibrillator")),
    MultiExpression.entry(
      new PoiClass("safety", "emergency", "hospital", 11, '⬤', 0),
      and(matchAny("amenity", "hospital"), matchAny("emergency", "yes"))),
    MultiExpression.entry(
      new PoiClass("safety", "rescue", "fire_station", 15, '⬤', 0),
      matchAny("amenity", "fire_station")),
    MultiExpression.entry(
      new PoiClass("safety", "rescue", "life_ring", 17, '•', 4),
      matchAny("emergency", "life_ring")),
    MultiExpression.entry(
      new PoiClass("safety", "rescue", "lifeguard_base", 17, '⬤', 0),
      matchAny("emergency", "lifeguard_base")),
    MultiExpression.entry(
      new PoiClass("safety", "rescue", "mountain_rescue", 17, '⬤', 0),
      matchAny("emergency", "mountain_rescue")),
    MultiExpression.entry(
      new PoiClass("safety", "rescue", "police", 17, '⬤', 0),
      matchAny("amenity", "police")),
    MultiExpression.entry(
      new PoiClass("safety", "rescue", "water_rescue_station", 17, '⬤', 0),
      matchAny("emergency", "water_rescue_station")),
    MultiExpression.entry(
      new PoiClass("services", "bank", null, 16, '⬤', 300),
      matchAny("amenity", "bank")),
    MultiExpression.entry(
      new PoiClass("services", "courthouse", null, 13, '⬤', 100),
      matchAny("amenity", "courthouse")),
    MultiExpression.entry(
      new PoiClass("services", "office", null, 14, '⬤', 300),
      matchAny("information", "office")),
    MultiExpression.entry(
      new PoiClass("services", "post_office", null, 15, '⬤', 100),
      matchAny("amenity", "post_office")),
    MultiExpression.entry(
      new PoiClass("services", "townhall", null, 11, '⬤', 20),
      matchAny("amenity", "townhall")),
    MultiExpression.entry(
      new PoiClass("services_shopping", "car_parts", null, 17, '⬤', 700),
      matchAny("shop", "car_parts")),
    MultiExpression.entry(
      new PoiClass("services_shopping", "car_repair", null, 17, '⬤', 700),
      matchAny("shop", "car_repair")),
    MultiExpression.entry(
      new PoiClass("services_shopping", "copyshop", null, 17, '⬤', 700),
      matchAny("shop", "copyshop")),
    MultiExpression.entry(
      new PoiClass("services_shopping", "coworking_space", null, 15, '⬤', 300),
      matchAny("amenity", "coworking_space")),
    MultiExpression.entry(
      new PoiClass("services_shopping", "dry_cleaning", null, 17, '⬤', 700),
      matchAny("shop", "dry_cleaning")),
    MultiExpression.entry(
      new PoiClass("services_shopping", "estate_agent", null, 17, '⬤', 300),
      matchAny("office", "estate_agent")),
    MultiExpression.entry(
      new PoiClass("services_shopping", "florist", null, 17, '⬤', 600),
      matchAny("shop", "florist")),
    MultiExpression.entry(
      new PoiClass("services_shopping", "kiosk", null, 16, '⬤', 400),
      matchAny("shop", "kiosk")),
    MultiExpression.entry(
      new PoiClass("services_shopping", "laundry", null, 17, '⬤', 700),
      matchAny("shop", "laundry")),
    MultiExpression.entry(
      new PoiClass("services_shopping", "motorcycle_repair", null, 17, '⬤', 700),
      matchAny("shop", "motorcycle_repair")),
    MultiExpression.entry(
      new PoiClass("services_shopping", "newsagent", null, 17, '⬤', 300),
      matchAny("shop", "newsagent")),
    MultiExpression.entry(
      new PoiClass("services_shopping", "tobacco", null, 17, '⬤', 300),
      matchAny("shop", "tobacco")),
    MultiExpression.entry(
      new PoiClass("services_shopping", "travel_agency", null, 16, '⬤', 700),
      matchAny("shop", "travel_agency")),
    MultiExpression.entry(
      new PoiClass("shopping", "animals", "pet", 17, '⬤', 1000),
      matchAny("shop", "pet")),
    MultiExpression.entry(
      new PoiClass("shopping", "animals", "pet_grooming", 17, '⬤', 1000),
      matchAny("shop", "pet_grooming")),
    MultiExpression.entry(
      new PoiClass("shopping", "body", "erotic", 17, '⬤', 700),
      matchAny("shop", "erotic")),
    MultiExpression.entry(
      new PoiClass("shopping", "body", "hairdresser", 17, '⬤', 600),
      matchAny("shop", "hairdresser")),
    MultiExpression.entry(
      new PoiClass("shopping", "body", "hearing_aids", 17, '⬤', 700),
      matchAny("shop", "hearing_aids")),
    MultiExpression.entry(
      new PoiClass("shopping", "body", "massage", 17, '⬤', 700),
      matchAny("shop", "massage")),
    MultiExpression.entry(
      new PoiClass("shopping", "body", "optician", 17, '⬤', 700),
      matchAny("shop", "optician")),
    MultiExpression.entry(
      new PoiClass("shopping", "body", "tattoo", 17, '⬤', 700),
      matchAny("shop", "tattoo")),
    MultiExpression.entry(
      new PoiClass("shopping", "fashion", "accessories", 17, '⬤', 700),
      matchAny("shop", "accessories")),
    MultiExpression.entry(
      new PoiClass("shopping", "fashion", "bag", 17, '⬤', 700),
      matchAny("shop", "bag")),
    MultiExpression.entry(
      new PoiClass("shopping", "fashion", "boutique", 17, '⬤', 700),
      matchAny("shop", "boutique")),
    MultiExpression.entry(
      new PoiClass("shopping", "fashion", "clothes", 17, '⬤', 700),
      matchAny("shop", "clothes")),
    MultiExpression.entry(
      new PoiClass("shopping", "fashion", "cosmetics", 17, '⬤', 700),
      matchAny("shop", "cosmetics")),
    MultiExpression.entry(
      new PoiClass("shopping", "fashion", "fabric", 17, '⬤', 700),
      matchAny("shop", "fabric")),
    MultiExpression.entry(
      new PoiClass("shopping", "fashion", "gift", 17, '⬤', 700),
      matchAny("shop", "gift")),
    MultiExpression.entry(
      new PoiClass("shopping", "fashion", "interior_decoration", 17, '⬤', 700),
      matchAny("shop", "interior_decoration")),
    MultiExpression.entry(
      new PoiClass("shopping", "fashion", "jewelry", 17, '⬤', 700),
      matchAny("shop", "jewelry")),
    MultiExpression.entry(
      new PoiClass("shopping", "fashion", "perfume", 17, '⬤', 700),
      matchAny("shop", "perfume")),
    MultiExpression.entry(
      new PoiClass("shopping", "fashion", "perfumery", 17, '⬤', 700),
      matchAny("shop", "perfumery")),
    MultiExpression.entry(
      new PoiClass("shopping", "fashion", "second_hand", 17, '⬤', 700),
      matchAny("shop", "second_hand")),
    MultiExpression.entry(
      new PoiClass("shopping", "fashion", "shoes", 17, '⬤', 700),
      matchAny("shop", "shoes")),
    MultiExpression.entry(
      new PoiClass("shopping", "fashion", "watches", 17, '⬤', 700),
      matchAny("shop", "watches")),
    MultiExpression.entry(
      new PoiClass("shopping", "feed", "beverages", 17, '⬤', 400),
      matchAny("shop", "beverages")),
    MultiExpression.entry(
      new PoiClass("shopping", "sport_supply", "bicycle_shop", 17, '⬤', 500),
      matchAny("shop", "bicycle")),
    MultiExpression.entry(
      new PoiClass("shopping", "sport_supply", "outdoor", 17, '⬤', 500),
      matchAny("shop", "outdoor")),
    MultiExpression.entry(
      new PoiClass("shopping", "sport_supply", "sports", 17, '⬤', 600),
      matchAny("shop", "sports")),
    MultiExpression.entry(
      new PoiClass("shopping", "sport_supply", "surf", 17, '⬤', 500),
      matchAny("shop", "surf")),
    MultiExpression.entry(
      new PoiClass("shopping", "various_supply", "agrarian", 17, '⬤', 700),
      matchAny("shop", "agrarian")),
    MultiExpression.entry(
      new PoiClass("shopping", "various_supply", "bed", 17, '⬤', 700),
      matchAny("shop", "bed")),
    MultiExpression.entry(
      new PoiClass("shopping", "various_supply", "camera", 17, '⬤', 700),
      matchAny("shop", "camera")),
    MultiExpression.entry(
      new PoiClass("shopping", "various_supply", "car", 17, '⬤', 700),
      matchAny("shop", "car")),
    MultiExpression.entry(
      new PoiClass("shopping", "various_supply", "charity", 17, '⬤', 700),
      matchAny("shop", "charity")),
    MultiExpression.entry(
      new PoiClass("shopping", "various_supply", "chemist", 17, '⬤', 600),
      matchAny("shop", "chemist")),
    MultiExpression.entry(
      new PoiClass("shopping", "various_supply", "computer", 17, '⬤', 700),
      matchAny("shop", "computer")),
    MultiExpression.entry(
      new PoiClass("shopping", "various_supply", "doityourself", 17, '⬤', 700),
      matchAny("shop", "doityourself")),
    MultiExpression.entry(
      new PoiClass("shopping", "various_supply", "electronics", 17, '⬤', 700),
      matchAny("shop", "electronics")),
    MultiExpression.entry(
      new PoiClass("shopping", "various_supply", "fishing_shop", 17, '⬤', 700),
      matchAny("shop", "fishing")),
    MultiExpression.entry(
      new PoiClass("shopping", "various_supply", "furniture", 17, '⬤', 700),
      matchAny("shop", "furniture")),
    MultiExpression.entry(
      new PoiClass("shopping", "various_supply", "general", 17, '⬤', 700),
      matchAny("shop", "general")),
    MultiExpression.entry(
      new PoiClass("shopping", "various_supply", "hardware", 17, '⬤', 700),
      matchAny("shop", "hardware")),
    MultiExpression.entry(
      new PoiClass("shopping", "various_supply", "hifi", 17, '⬤', 700),
      matchAny("shop", "hifi")),
    MultiExpression.entry(
      new PoiClass("shopping", "various_supply", "lamps", 17, '⬤', 700),
      matchAny("shop", "lamps")),
    MultiExpression.entry(
      new PoiClass("shopping", "various_supply", "mobile_phone", 17, '⬤', 700),
      matchAny("shop", "mobile_phone")),
    MultiExpression.entry(
      new PoiClass("shopping", "various_supply", "motorcycle", 17, '⬤', 700),
      matchAny("shop", "motorcycle")),
    MultiExpression.entry(
      new PoiClass("shopping", "various_supply", "musical_instrument", 17, '⬤', 700),
      matchAny("shop", "musical_instrument")),
    MultiExpression.entry(
      new PoiClass("shopping", "various_supply", "stationery", 17, '⬤', 700),
      matchAny("shop", "stationery")),
    MultiExpression.entry(
      new PoiClass("shopping", "various_supply", "toys", 17, '⬤', 700),
      matchAny("shop", "toys")),
    MultiExpression.entry(
      new PoiClass("shopping", "various_supply", "video", 17, '⬤', 700),
      matchAny("shop", "video")),
    MultiExpression.entry(
      new PoiClass("shopping", "various_supply", "video_games", 17, '⬤', 700),
      matchAny("shop", "video_games")),
    MultiExpression.entry(
      new PoiClass("shopping", "various_supply", "weapons", 17, '⬤', 700),
      matchAny("shop", "weapons")),
    MultiExpression.entry(
      new PoiClass("shopping", "various_supply", "wholesale", 17, '⬤', 700),
      matchAny("shop", "wholesale")),
    MultiExpression.entry(
      new PoiClass("social_services", "solidarity", "disabled_home", 16, '⬤', 200),
      and(matchAny("amenity", "social_facility"), matchAny("social_facility:for", "disabled"))),
    MultiExpression.entry(
      new PoiClass("social_services", "solidarity", "elderly_nursing_home", 16, '⬤', 200),
      and(matchAny("amenity", "social_facility"), matchAny("social_facility", "nursing_home"),
        matchAny("social_facility:for", "senior"))),
    MultiExpression.entry(
      new PoiClass("social_services", "solidarity", "food_bank", 15, '⬤', 200),
      and(matchAny("amenity", "social_facility"), matchAny("social_facility", "food_bank"))),
    MultiExpression.entry(
      new PoiClass("social_services", "solidarity", "retirement_home", 16, '⬤', 200),
      and(matchAny("amenity", "social_facility"), matchAny("social_facility", "group_home"),
        matchAny("social_facility:for", "senior"))),
    MultiExpression.entry(
      new PoiClass("social_services", "solidarity", "social_information", 15, '⬤', 200),
      and(matchAny("amenity", "social_facility"), matchAny("social_facility", "outreach")))
  };

  public static MultiExpression.Index<PoiClass> POI_CLASS =
    MultiExpression.of(Arrays.asList((MultiExpression.Entry<PoiClass>[]) POI_CLASS_ENTRIES)).simplify().index();
}