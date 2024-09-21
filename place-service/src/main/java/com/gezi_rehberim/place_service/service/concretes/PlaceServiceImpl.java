package com.gezi_rehberim.place_service.service.concretes;

import com.gezi_rehberim.place_service.core.exception.place.PlaceNotFoundException;
import com.gezi_rehberim.place_service.core.message.PlaceMessage;
import com.gezi_rehberim.place_service.dto.request.place.CreatePlaceRequest;
import com.gezi_rehberim.place_service.dto.request.place.UpdatePlaceRequest;
import com.gezi_rehberim.place_service.dto.response.place.*;
import com.gezi_rehberim.place_service.mapper.PlaceMapping;
import com.gezi_rehberim.place_service.model.Place;
import com.gezi_rehberim.place_service.repositories.PlaceRepository;
import com.gezi_rehberim.place_service.service.abstracts.PlaceService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PlaceServiceImpl implements PlaceService {

    private final PlaceRepository placeRepository;

    public PlaceServiceImpl(PlaceRepository placeRepository) {
        this.placeRepository = placeRepository;
    }

    @Override
    public CreatePlaceResponse createPlace(CreatePlaceRequest request) {
        Place place = PlaceMapping.INSTANCE.createPlace(request);
        Place savedPlace = placeRepository.save(place);
        return new CreatePlaceResponse(savedPlace.getId(),savedPlace.getName(),savedPlace.getDescription(),savedPlace.getAddress(),savedPlace.getLatitude(),savedPlace.getLongitude(),savedPlace.getPlaceCategory().getId());
    }

    @Override
    public UpdatePlaceResponse updatePlace(UpdatePlaceRequest request, int id) {
        Optional<Place> place = placeRepository.findById(id);
        if (place.isEmpty())
        {
            throw new PlaceNotFoundException(PlaceMessage.PLACE_NOT_FOUND);
        }
        Place placeToUpdate = place.get();
        Place updatedPlace = PlaceMapping.INSTANCE.updatePlace(request, placeToUpdate);
        Place savedPlace = placeRepository.save(updatedPlace);
        return new UpdatePlaceResponse(savedPlace.getId(),savedPlace.getName(),savedPlace.getDescription(),savedPlace.getAddress(),savedPlace.getLatitude(),savedPlace.getLongitude(),savedPlace.getPlaceCategory().getId());
    }

    @Override
    public Optional<GetByIdPlaceResponse> getByIdPlace(int id) {
        Optional<Place> place = placeRepository.findById(id);
        if (place.isEmpty())
        {
            throw new PlaceNotFoundException(PlaceMessage.PLACE_NOT_FOUND);
        }
        return place.map(PlaceMapping.INSTANCE::getByIdPlace);
    }

    @Override
    public List<GetAllPlaceResponse> getAllPlaceList() {
        List<Place> places = placeRepository.findAll();
        return PlaceMapping.INSTANCE.placeToListPlace(places);
    }

    @Override
    public List<GetByPlaceWithPlaceCategoryResponse> getByPlaceWithPlaceCategory(int id) {
        List<Place> placeList = placeRepository.findAllByPlaceCategoryId(id);
        return PlaceMapping.INSTANCE.placeListToPlaceWithPlaceCategory(placeList);
    }

    @Override
    public void deletePlace(int id) {
        Optional<Place> optionalPlace = placeRepository.findById(id);
        if (optionalPlace.isEmpty())
        {
            throw new PlaceNotFoundException(PlaceMessage.PLACE_NOT_FOUND);
        }
        placeRepository.deleteById(id);

    }
}