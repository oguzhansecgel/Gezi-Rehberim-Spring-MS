package com.gezi_rehberim.place_service.service.concretes;

import com.gezi_rehberim.place_service.core.exception.place.PlaceNotFoundException;
import com.gezi_rehberim.place_service.core.message.PlaceMessage;
import com.gezi_rehberim.place_service.dto.request.place.CreatePlaceRequest;
import com.gezi_rehberim.place_service.dto.request.place.UpdatePlaceRequest;
import com.gezi_rehberim.place_service.dto.response.place.*;
import com.gezi_rehberim.place_service.kafka.producer.SearchServiceProducer;
import com.gezi_rehberim.place_service.mapper.PlaceMapping;
import com.gezi_rehberim.place_service.model.Place;
import com.gezi_rehberim.place_service.repositories.PlaceRepositories;
import com.gezi_rehberim.place_service.core.service.abstracts.PlaceImageService;
import com.gezi_rehberim.place_service.service.abstracts.PlaceService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class PlaceServiceImpl implements PlaceService {

    private final PlaceRepositories placeRepositories;
    private final PlaceImageService placeImageService;
    private final SearchServiceProducer searchServiceProducer;
    private final PlaceMapping placeMapping;
    private static final Logger logger = LoggerFactory.getLogger(PlaceService.class);
    public PlaceServiceImpl(PlaceRepositories placeRepositories, PlaceImageService placeImageService, SearchServiceProducer searchServiceProducer, PlaceMapping placeMapping) {
        this.placeRepositories = placeRepositories;
        this.placeImageService = placeImageService;
        this.searchServiceProducer = searchServiceProducer;
        this.placeMapping = placeMapping;
    }

    @Override
    public CreatePlaceResponse createPlace(CreatePlaceRequest request) {
        Place place = placeMapping.createPlace(request);
        logger.info("Place created: {}", place);
        List<String> imageUrls = placeImageService.savePlaceImages(request.getImageUrls());

        place.setImageUrls(imageUrls);

        Place savedPlace = placeRepositories.save(place);

        searchServiceProducer.sendMessage(new CreatePlaceResponse(
                savedPlace.getId(),
                savedPlace.getName(),
                savedPlace.getDescription(),
                savedPlace.getAddress(),
                savedPlace.getLatitude(),
                savedPlace.getLongitude(),
                savedPlace.getPlaceCategory().getId()
        ));

        return new CreatePlaceResponse(
                savedPlace.getId(),
                savedPlace.getName(),
                savedPlace.getDescription(),
                savedPlace.getAddress(),
                savedPlace.getLatitude(),
                savedPlace.getLongitude(),
                savedPlace.getPlaceCategory().getId()
        );

    }

    @Override
    public UpdatePlaceResponse updatePlace(UpdatePlaceRequest request, int id) {
        Optional<Place> place = placeRepositories.findById(id);

        if (place.isEmpty())
        {
            throw new PlaceNotFoundException(PlaceMessage.PLACE_NOT_FOUND);
        }
        Place placeToUpdate = place.get();
        Place updatedPlace = placeMapping.updatePlace(request, placeToUpdate);
        Place savedPlace = placeRepositories.save(updatedPlace);
        return new UpdatePlaceResponse(savedPlace.getId(),savedPlace.getName(),savedPlace.getDescription(),savedPlace.getAddress(),savedPlace.getLatitude(),savedPlace.getLongitude(),savedPlace.getImageUrls(),savedPlace.getPlaceCategory().getId());
    }

    @Override
    public Optional<GetByIdPlaceResponse> getByIdPlace(int id) {
        Optional<Place> place = placeRepositories.findById(id);
        logger.info("GetById {}",id);
        if (place.isEmpty())
        {
            throw new PlaceNotFoundException(PlaceMessage.PLACE_NOT_FOUND);
        }
        return place.map(placeMapping::getByIdPlace);
    }

    @Override
    public List<GetAllPlaceResponse> getAllPlaceList() {
        List<Place> places = placeRepositories.findAll();
        logger.info("GetAllPlace List");
        return placeMapping.placeToListPlace(places);
    }

    @Override
    public List<GetByPlaceWithPlaceCategoryResponse> getByPlaceWithPlaceCategory(int id) {
        List<Place> placeList = placeRepositories.findAllByPlaceCategoryId(id);
        return placeMapping.placeListToPlaceWithPlaceCategory(placeList);
    }

    @Override
    public void deletePlace(int id) {
        Optional<Place> optionalPlace = placeRepositories.findById(id);
        if (optionalPlace.isEmpty()) {
            logger.error(PlaceMessage.PLACE_NOT_FOUND);
            throw new PlaceNotFoundException(PlaceMessage.PLACE_NOT_FOUND);
        }

        Place place = optionalPlace.get();

        List<String> imageUrls = place.getImageUrls();
        placeImageService.deletedImage(imageUrls);

        placeRepositories.deleteById(id);
    }
}
