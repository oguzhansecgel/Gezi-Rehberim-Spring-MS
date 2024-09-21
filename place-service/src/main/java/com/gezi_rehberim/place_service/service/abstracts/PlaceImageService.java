package com.gezi_rehberim.place_service.service.abstracts;

import com.gezi_rehberim.place_service.dto.request.placeimage.CreatePlaceImageRequest;
import com.gezi_rehberim.place_service.dto.response.placeimage.CreatePlaceImageResponse;
import com.gezi_rehberim.place_service.dto.response.placeimage.GetAllPlaceImageResponse;
import com.gezi_rehberim.place_service.dto.response.placeimage.GetByIdPlaceImageResponse;
import com.gezi_rehberim.place_service.dto.response.placeimage.GetByPlaceImageWithPlaceResponse;

import java.util.List;
import java.util.Optional;

public interface PlaceImageService {
    CreatePlaceImageResponse createPlaceImage(CreatePlaceImageRequest request);
    void deletedImage(int placeImageId);
    List<GetByPlaceImageWithPlaceResponse> getPlaceImageWithPlace(int placeId);
    List<GetAllPlaceImageResponse> getAllPlaceImage();
    Optional<GetByIdPlaceImageResponse> getPlaceImageById(int placeImageId);
}
