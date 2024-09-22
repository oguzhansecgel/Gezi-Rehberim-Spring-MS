package com.gezi_rehberim.place_service.mapper;

import com.gezi_rehberim.place_service.dto.request.placeimage.CreatePlaceImageRequest;
import com.gezi_rehberim.place_service.dto.response.placeimage.GetAllPlaceImageResponse;
import com.gezi_rehberim.place_service.dto.response.placeimage.GetByIdPlaceImageResponse;
import com.gezi_rehberim.place_service.dto.response.placeimage.GetByPlaceImageWithPlaceResponse;
import com.gezi_rehberim.place_service.model.PlaceImage;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface PlaceImageMapping {

    PlaceImageMapping INSTANCE = Mappers.getMapper(PlaceImageMapping.class);

    @Mapping(source = "placeId",target = "place.id")
    PlaceImage createPlaceImage(CreatePlaceImageRequest request);

    @Mapping(source ="place.id" ,target = "placeId")
    @Mapping(source = "imageUrl",target = "imageFile")
    GetByIdPlaceImageResponse getByIdPlaceImage(PlaceImage placeImage);

    @Mapping(source ="place.id" ,target = "placeId")
    @Mapping(source = "id", target = "id")
    GetByPlaceImageWithPlaceResponse getByPlaceImageWithPlaceResponse(PlaceImage placeImage);
    List<GetByPlaceImageWithPlaceResponse> listByPlaceImageWithPlaceResponse(List<PlaceImage> placeImage);

    @Mapping(source ="place.id" ,target = "placeId")
    @Mapping(source = "id", target = "id")
    GetAllPlaceImageResponse getByPlaceImageResponse(PlaceImage placeImage);
    List<GetAllPlaceImageResponse> placeToListPlaceImageResponse(List<PlaceImage> placeImage);

}
