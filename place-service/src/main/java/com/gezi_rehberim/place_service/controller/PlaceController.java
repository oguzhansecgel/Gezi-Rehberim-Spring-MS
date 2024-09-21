package com.gezi_rehberim.place_service.controller;

import com.gezi_rehberim.place_service.dto.request.place.CreatePlaceRequest;
import com.gezi_rehberim.place_service.dto.request.place.UpdatePlaceRequest;
import com.gezi_rehberim.place_service.dto.response.place.*;
import com.gezi_rehberim.place_service.service.abstracts.PlaceService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("api/place")
public class PlaceController {


    private final PlaceService placeService;

    public PlaceController(PlaceService placeService) {
        this.placeService = placeService;
    }

    @GetMapping("/getById/place/{id}")
    public Optional<GetByIdPlaceResponse> getByIdPlaceResponse(@PathVariable int id)
    {
        return placeService.getByIdPlace(id);
    }
    @GetMapping("/getAllList/place")
    public List<GetAllPlaceResponse> getAllPlaceResponseList()
    {
        return placeService.getAllPlaceList();
    }
    @GetMapping("/getList/PlaceWithPlaceCategory/{categoryId}")
    public List<GetByPlaceWithPlaceCategoryResponse> getByPlaceWithPlaceCategoryResponses(@PathVariable int categoryId)
    {
        return placeService.getByPlaceWithPlaceCategory(categoryId);
    }
    @DeleteMapping("/delete/place/{id}")
    public void deletePlace(@PathVariable int id)
    {
        placeService.deletePlace(id);
    }
    @PostMapping("/create/place")
    public CreatePlaceResponse createPlace(@RequestBody CreatePlaceRequest createPlaceRequest)
    {
        return placeService.createPlace(createPlaceRequest);
    }
    @PutMapping("/update/place/{id}")
    public UpdatePlaceResponse updatePlace(@PathVariable int id, @RequestBody UpdatePlaceRequest updatePlaceRequest)
    {
        return placeService.updatePlace(updatePlaceRequest,id);
    }


}
