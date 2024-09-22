package com.gezi_rehberim.search_service.service.concretes;

import com.gezi_rehberim.search_service.document.Place;
import com.gezi_rehberim.search_service.repositories.PlaceRepository;
import com.gezi_rehberim.search_service.service.abstracts.PlaceService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PlaceServiceImpl implements PlaceService {

    private final PlaceRepository placeRepository;

    public PlaceServiceImpl(PlaceRepository placeRepository) {
        this.placeRepository = placeRepository;
    }

    @Override
    public Place createPlace(Place place) {
        return placeRepository.save(place);
    }

    @Override
    public Iterable<Place> getAllPlaces() {
        return placeRepository.findAll();

    }

    @Override
    public List<Place> searchPlaceName(String name) {
        return placeRepository.searchByName(name);

    }
}
