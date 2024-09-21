package com.gezi_rehberim.place_service.mapper;

import com.gezi_rehberim.place_service.dto.request.placecategory.CreatePlaceCategoryRequest;
import com.gezi_rehberim.place_service.dto.request.placecategory.UpdatePlaceCategoryRequest;
import com.gezi_rehberim.place_service.dto.response.placecategory.GetAllPlaceCategoryResponse;
import com.gezi_rehberim.place_service.dto.response.placecategory.GetByIdPlaceCategoryResponse;
import com.gezi_rehberim.place_service.model.PlaceCategory;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface PlaceCategoryMapping {

    PlaceCategoryMapping INSTANCE = Mappers.getMapper(PlaceCategoryMapping.class);

    PlaceCategory createPlaceCategory(CreatePlaceCategoryRequest request);

    PlaceCategory updatePlaceCategory(UpdatePlaceCategoryRequest request, @MappingTarget PlaceCategory placeCategory);

    GetByIdPlaceCategoryResponse getByIdPlaceCategory(PlaceCategory placeCategory);

    GetAllPlaceCategoryResponse getAllPlaceCategory(PlaceCategory placeCategory);
    List<GetAllPlaceCategoryResponse> placeCategoryListPlaceCategory(List<PlaceCategory> placeCategory);
}
