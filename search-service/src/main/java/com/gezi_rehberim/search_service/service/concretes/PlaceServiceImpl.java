package com.gezi_rehberim.search_service.service.concretes;

import com.gezi_rehberim.search_service.document.Place;
import com.gezi_rehberim.search_service.repositories.PlaceRepositories;
import com.gezi_rehberim.search_service.service.abstracts.PlaceService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PlaceServiceImpl implements PlaceService {

    private final PlaceRepositories placeRepositories;

    public PlaceServiceImpl(PlaceRepositories placeRepositories) {
        this.placeRepositories = placeRepositories;
    }

    @Override
    public Place createPlace(Place place) {
        return placeRepositories.save(place);
    }

    @Override
    public Iterable<Place> getAllPlaces() {
        return placeRepositories.findAll();

    }

    @Override
    public List<Place> searchPlaceName(String name) {
        return placeRepositories.searchByName(name);

    }
}
