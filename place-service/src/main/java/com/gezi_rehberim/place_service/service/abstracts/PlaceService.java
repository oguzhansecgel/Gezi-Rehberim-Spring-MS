package com.gezi_rehberim.place_service.service.abstracts;

import com.gezi_rehberim.place_service.dto.request.place.CreatePlaceRequest;
import com.gezi_rehberim.place_service.dto.request.place.UpdatePlaceRequest;
import com.gezi_rehberim.place_service.dto.response.place.*;

import java.util.List;
import java.util.Optional;

public interface PlaceService {

    CreatePlaceResponse createPlace(CreatePlaceRequest request);
    UpdatePlaceResponse updatePlace(UpdatePlaceRequest request, int id);
    Optional<GetByIdPlaceResponse> getByIdPlace(int id);
    List<GetAllPlaceResponse> getAllPlaceList();
    List<GetByPlaceWithPlaceCategoryResponse> getByPlaceWithPlaceCategory(int id);
    void deletePlace(int id);


}
