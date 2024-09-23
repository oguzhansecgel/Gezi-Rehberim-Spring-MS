package com.gezi_rehberim.place_service.mapper;

import com.gezi_rehberim.place_service.dto.request.place.CreatePlaceRequest;
import com.gezi_rehberim.place_service.dto.request.place.UpdatePlaceRequest;
import com.gezi_rehberim.place_service.dto.response.place.GetAllPlaceResponse;
import com.gezi_rehberim.place_service.dto.response.place.GetByIdPlaceResponse;
import com.gezi_rehberim.place_service.dto.response.place.GetByPlaceWithPlaceCategoryResponse;
import com.gezi_rehberim.place_service.model.Place;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import org.mapstruct.factory.Mappers;
import org.springframework.web.multipart.MultipartFile;

import java.util.ArrayList;
import java.util.List;

@Mapper
public interface PlaceMapping {

        PlaceMapping INSTANCE = Mappers.getMapper(PlaceMapping.class);


        @Mapping(source = "placeCategoryId", target = "placeCategory.id")
        Place createPlace(CreatePlaceRequest request);

        Place updatePlace(UpdatePlaceRequest request,@MappingTarget Place place);

        GetByIdPlaceResponse getByIdPlace(Place place);

        @Mapping(source = "placeCategory.id",target = "placeCategoryId")
        GetAllPlaceResponse getAllPlaces(Place place);
        List<GetAllPlaceResponse> placeToListPlace(List<Place> place);

        @Mapping(source = "placeCategory.id",target = "placeCategoryId")
        GetByPlaceWithPlaceCategoryResponse getByPlaceWithPlaceCategory(Place place);
        List<GetByPlaceWithPlaceCategoryResponse> placeListToPlaceWithPlaceCategory(List<Place> place);

        default List<String> map(List<MultipartFile> files) {
                List<String> urls = new ArrayList<>();
                for (MultipartFile file : files) {
                        urls.add(file.getOriginalFilename());
                }
                return urls;
        }
}
