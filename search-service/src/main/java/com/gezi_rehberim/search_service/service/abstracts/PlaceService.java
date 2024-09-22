package com.gezi_rehberim.search_service.service.abstracts;

import com.gezi_rehberim.search_service.document.Place;

import java.util.List;

public interface PlaceService {
    Place createPlace(Place place);
    Iterable<Place> getAllPlaces();
    List<Place> searchPlaceName(String name);
}
