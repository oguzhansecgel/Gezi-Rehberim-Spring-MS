package com.gezi_rehberim.place_service.service.concretes;

import com.gezi_rehberim.place_service.core.exception.placecategory.PlaceCategoryNotFoundException;
import com.gezi_rehberim.place_service.core.message.PlaceCategoryMessage;
import com.gezi_rehberim.place_service.dto.request.placecategory.CreatePlaceCategoryRequest;
import com.gezi_rehberim.place_service.dto.request.placecategory.UpdatePlaceCategoryRequest;
import com.gezi_rehberim.place_service.dto.response.placecategory.CreatePlaceCategoryResponse;
import com.gezi_rehberim.place_service.dto.response.placecategory.GetAllPlaceCategoryResponse;
import com.gezi_rehberim.place_service.dto.response.placecategory.GetByIdPlaceCategoryResponse;
import com.gezi_rehberim.place_service.dto.response.placecategory.UpdatePlaceCategoryResponse;
import com.gezi_rehberim.place_service.mapper.PlaceCategoryMapping;
import com.gezi_rehberim.place_service.model.PlaceCategory;
import com.gezi_rehberim.place_service.repositories.PlaceCategoryRepository;
import com.gezi_rehberim.place_service.service.abstracts.PlaceCategoryService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PlaceCategoryServiceImpl implements PlaceCategoryService {

    private final PlaceCategoryRepository placeCategoryRepository;

    public PlaceCategoryServiceImpl(PlaceCategoryRepository placeCategoryRepository) {
        this.placeCategoryRepository = placeCategoryRepository;
    }

    @Override
    public List<GetAllPlaceCategoryResponse> getAllPlaceCategory() {
        List<PlaceCategory> placeCategoryList = placeCategoryRepository.findAll();
        return PlaceCategoryMapping.INSTANCE.placeCategoryListPlaceCategory(placeCategoryList);
    }

    @Override
    public Optional<GetByIdPlaceCategoryResponse> getByIdPlaceCategory(int id) {
        Optional<PlaceCategory> placeCategory = placeCategoryRepository.findById(id);
        if (placeCategory.isEmpty())
        {
            throw new PlaceCategoryNotFoundException(PlaceCategoryMessage.PLACE_CATEGORY_NOT_FOUND);
        }

        return placeCategory.map(PlaceCategoryMapping.INSTANCE::getByIdPlaceCategory);
    }

    @Override
    public CreatePlaceCategoryResponse createPlaceCategory(CreatePlaceCategoryRequest request) {
        PlaceCategory placeCategory = PlaceCategoryMapping.INSTANCE.createPlaceCategory(request);
        PlaceCategory savedPlaceCategory = placeCategoryRepository.save(placeCategory);
        return new CreatePlaceCategoryResponse(savedPlaceCategory.getId(), savedPlaceCategory.getCategoryName());
    }

    @Override
    public UpdatePlaceCategoryResponse updatePlaceCategory(UpdatePlaceCategoryRequest request, int id) {
        Optional<PlaceCategory> optionalPlaceCategory = placeCategoryRepository.findById(id);
        if (optionalPlaceCategory.isEmpty())
        {
            throw new PlaceCategoryNotFoundException(PlaceCategoryMessage.PLACE_CATEGORY_NOT_FOUND);
        }
        PlaceCategory existingPlaceCategory = optionalPlaceCategory.get();
        PlaceCategory placeCategory = PlaceCategoryMapping.INSTANCE.updatePlaceCategory(request, existingPlaceCategory);
        PlaceCategory savedPlaceCategory = placeCategoryRepository.save(placeCategory);
        return new UpdatePlaceCategoryResponse(savedPlaceCategory.getId(), savedPlaceCategory.getCategoryName());
    }

    @Override
    public void deletePlaceCategory(int id) {
        Optional<PlaceCategory> optionalPlaceCategory  = placeCategoryRepository.findById(id);
        if (optionalPlaceCategory.isEmpty())
        {
            throw new PlaceCategoryNotFoundException(PlaceCategoryMessage.PLACE_CATEGORY_NOT_FOUND);
        }
        placeCategoryRepository.deleteById(id);
    }
}
