package com.gezi_rehberim.place_service.service.abstracts;

import com.gezi_rehberim.place_service.dto.request.placecategory.CreatePlaceCategoryRequest;
import com.gezi_rehberim.place_service.dto.request.placecategory.UpdatePlaceCategoryRequest;
import com.gezi_rehberim.place_service.dto.response.placecategory.CreatePlaceCategoryResponse;
import com.gezi_rehberim.place_service.dto.response.placecategory.GetAllPlaceCategoryResponse;
import com.gezi_rehberim.place_service.dto.response.placecategory.GetByIdPlaceCategoryResponse;
import com.gezi_rehberim.place_service.dto.response.placecategory.UpdatePlaceCategoryResponse;

import java.util.List;
import java.util.Optional;
public interface PlaceCategoryService {

    List<GetAllPlaceCategoryResponse> getAllPlaceCategory();
    Optional<GetByIdPlaceCategoryResponse> getByIdPlaceCategory(int id);
    CreatePlaceCategoryResponse createPlaceCategory(CreatePlaceCategoryRequest request);
    UpdatePlaceCategoryResponse updatePlaceCategory(UpdatePlaceCategoryRequest request,int id);
    void deletePlaceCategory(int id);
}
