package com.gezi_rehberim.place_service.controller;

import com.gezi_rehberim.place_service.dto.request.placeimage.CreatePlaceImageRequest;
import com.gezi_rehberim.place_service.dto.response.placeimage.CreatePlaceImageResponse;
import com.gezi_rehberim.place_service.dto.response.placeimage.GetAllPlaceImageResponse;
import com.gezi_rehberim.place_service.dto.response.placeimage.GetByIdPlaceImageResponse;
import com.gezi_rehberim.place_service.dto.response.placeimage.GetByPlaceImageWithPlaceResponse;
import com.gezi_rehberim.place_service.service.abstracts.PlaceImageService;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("api/placeImage")
public class PlaceImageController {
    private final PlaceImageService placeImageService;

    public PlaceImageController(PlaceImageService placeImageService) {
        this.placeImageService = placeImageService;
    }
    @GetMapping("/list/placeImage")
    public List<GetAllPlaceImageResponse> getAllPlaceImage()
    {
        return placeImageService.getAllPlaceImage();
    }
    @GetMapping("/placeImageWithPlace/{placeId}")
    public List<GetByPlaceImageWithPlaceResponse> getByPlaceImageWithPlace(@PathVariable int placeId)
    {
        return placeImageService.getPlaceImageWithPlace(placeId);
    }
    @GetMapping("/getById/placeImage/{id}")
    public Optional<GetByIdPlaceImageResponse> getByIdPlaceImage(@PathVariable int id)
    {
        return placeImageService.getPlaceImageById(id);
    }
    @ApiOperation(value = "Food Image Upload", notes = "Upload an image for food.")
    @PostMapping(value = "/create/placeImage", consumes = "multipart/form-data")
    public CreatePlaceImageResponse createPlaceImageResponse(
            @ApiParam(value = "Image file", required = true) @RequestParam("imageFile") MultipartFile imageFile,
            @ApiParam(value = "Food ID", required = true) @RequestParam("placeId") int placeId) {

        CreatePlaceImageRequest createPlaceImageRequest = new CreatePlaceImageRequest();
        createPlaceImageRequest.setPlaceId(placeId);
        createPlaceImageRequest.setImageFile(imageFile);
        return placeImageService.createPlaceImage(createPlaceImageRequest);
    }
    @DeleteMapping("/delete/placeImage/{id}")
    public void deletePlaceImage(@PathVariable("id") int id)
    {
        placeImageService.deletedImage(id);
    }
}
