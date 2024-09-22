package com.gezi_rehberim.search_service.controller;

import com.gezi_rehberim.search_service.document.Place;
import com.gezi_rehberim.search_service.service.abstracts.PlaceService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("place/search")
public class PlaceSearchController {

    private final PlaceService placeService;

    public PlaceSearchController(PlaceService placeService) {
        this.placeService = placeService;
    }

    @GetMapping("/listAll/place")
    public Iterable<Place> getAllPlaces()
    {
        return placeService.getAllPlaces();
    }
    @GetMapping("/search/placeName/{name}")
    public List<Place> getPlaceByName(@PathVariable String name)
    {
        return placeService.searchPlaceName(name);
    }
}
