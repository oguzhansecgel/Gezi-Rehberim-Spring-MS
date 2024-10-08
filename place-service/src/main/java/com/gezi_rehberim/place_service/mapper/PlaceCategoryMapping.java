package com.gezi_rehberim.place_service.mapper;

import com.gezi_rehberim.place_service.dto.request.placecategory.CreatePlaceCategoryRequest;
import com.gezi_rehberim.place_service.dto.request.placecategory.UpdatePlaceCategoryRequest;
import com.gezi_rehberim.place_service.dto.response.placecategory.GetAllPlaceCategoryResponse;
import com.gezi_rehberim.place_service.dto.response.placecategory.GetByIdPlaceCategoryResponse;
import com.gezi_rehberim.place_service.model.PlaceCategory;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import org.mapstruct.factory.Mappers;
import org.springframework.stereotype.Component;

import java.util.List;

@Mapper(componentModel = "spring")
public interface PlaceCategoryMapping {



    PlaceCategory createPlaceCategory(CreatePlaceCategoryRequest request);

    PlaceCategory updatePlaceCategory(UpdatePlaceCategoryRequest request, @MappingTarget PlaceCategory placeCategory);

    GetByIdPlaceCategoryResponse getByIdPlaceCategory(PlaceCategory placeCategory);

    GetAllPlaceCategoryResponse getAllPlaceCategory(PlaceCategory placeCategory);
    List<GetAllPlaceCategoryResponse> placeCategoryListPlaceCategory(List<PlaceCategory> placeCategory);
}
