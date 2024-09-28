package com.gezi_rehberim.place_service.controller;

import com.gezi_rehberim.place_service.dto.request.placecategory.CreatePlaceCategoryRequest;
import com.gezi_rehberim.place_service.dto.request.placecategory.UpdatePlaceCategoryRequest;
import com.gezi_rehberim.place_service.dto.response.placecategory.CreatePlaceCategoryResponse;
import com.gezi_rehberim.place_service.dto.response.placecategory.GetAllPlaceCategoryResponse;
import com.gezi_rehberim.place_service.dto.response.placecategory.GetByIdPlaceCategoryResponse;
import com.gezi_rehberim.place_service.dto.response.placecategory.UpdatePlaceCategoryResponse;
import com.gezi_rehberim.place_service.service.abstracts.PlaceCategoryService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("api/placeCategory")
public class PlaceCategoryController {


    private final PlaceCategoryService placeCategoryService;

    public PlaceCategoryController(PlaceCategoryService placeCategoryService) {
        this.placeCategoryService = placeCategoryService;
    }
    @GetMapping("/getById/placeCategory/{id}")
    public Optional<GetByIdPlaceCategoryResponse> getByIdPlaceCategory(@PathVariable int id)
    {
        return placeCategoryService.getByIdPlaceCategory(id);
    }
    @GetMapping("/listAll/placeCategory")
    public List<GetAllPlaceCategoryResponse> getAllPlaceCategoryResponseList()
    {
        return placeCategoryService.getAllPlaceCategory();
    }
    @DeleteMapping("/delete/placeCategory/{id}")
    public void deletePlaceCategory(@PathVariable int id)
    {
        placeCategoryService.deletePlaceCategory(id);
    }
    @PostMapping("/create/placeCategory")
    public CreatePlaceCategoryResponse createPlaceCategory(@RequestBody CreatePlaceCategoryRequest createPlaceCategoryRequest)
    {
        return placeCategoryService.createPlaceCategory(createPlaceCategoryRequest);
    }
    @PutMapping("/update/placeCategory/{id}")
    public UpdatePlaceCategoryResponse updatePlaceCategory(@RequestBody UpdatePlaceCategoryRequest updatePlaceCategoryRequest, @PathVariable int id)
    {
        return placeCategoryService.updatePlaceCategory(updatePlaceCategoryRequest,id);
    }
}

