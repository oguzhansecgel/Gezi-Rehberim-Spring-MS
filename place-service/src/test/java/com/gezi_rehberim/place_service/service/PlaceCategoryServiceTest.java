package com.gezi_rehberim.place_service.service;

import com.gezi_rehberim.place_service.core.exception.placecategory.PlaceCategoryNotFoundException;
import com.gezi_rehberim.place_service.core.message.PlaceCategoryMessage;
import com.gezi_rehberim.place_service.dto.request.placecategory.CreatePlaceCategoryRequest;
import com.gezi_rehberim.place_service.dto.request.placecategory.UpdatePlaceCategoryRequest;
import com.gezi_rehberim.place_service.dto.response.placecategory.CreatePlaceCategoryResponse;
import com.gezi_rehberim.place_service.dto.response.placecategory.GetAllPlaceCategoryResponse;
import com.gezi_rehberim.place_service.dto.response.placecategory.GetByIdPlaceCategoryResponse;
import com.gezi_rehberim.place_service.dto.response.placecategory.UpdatePlaceCategoryResponse;
import com.gezi_rehberim.place_service.mapper.PlaceCategoryMapping;
import com.gezi_rehberim.place_service.model.PlaceCategory;
import com.gezi_rehberim.place_service.repositories.PlaceCategoryRepositories;
import com.gezi_rehberim.place_service.service.concretes.PlaceCategoryServiceImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.junit.Assert.*;
import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class PlaceCategoryServiceTest {

    @InjectMocks
    private PlaceCategoryServiceImpl placeCategoryService;

    @Mock
    private PlaceCategoryRepositories placeCategoryRepositories;

    @Mock
    private PlaceCategoryMapping placeCategoryMapping;


    @Test
    void whenGetAllPlaceCategory_thenReturnPlaceCategoryList()
    {
        PlaceCategory category1 = new PlaceCategory();
        category1.setId(1);
        category1.setCategoryName("Category 1");

        PlaceCategory category2 = new PlaceCategory();
        category2.setId(2);
        category2.setCategoryName("Category 2");

        List<PlaceCategory> placeCategories = Arrays.asList(category1, category2);
        List<GetAllPlaceCategoryResponse> placeCategoryResponses = placeCategoryMapping.placeCategoryListPlaceCategory(placeCategories);

        when(placeCategoryRepositories.findAll()).thenReturn(placeCategories);



        List<GetAllPlaceCategoryResponse> result = placeCategoryService.getAllPlaceCategory();

        assertEquals(placeCategoryResponses.size(), result.size());


    }
    @Test
    void getByPlaceCategoryId_whenPlaceCategoryExists_thenReturnPlaceCategory()
    {
        int placeCategoryId = 1;
        PlaceCategory category = new PlaceCategory();
        category.setId(placeCategoryId);
        category.setCategoryName("Category 1");

        GetByIdPlaceCategoryResponse getByIdPlaceCategoryResponse = new GetByIdPlaceCategoryResponse();
        getByIdPlaceCategoryResponse.setCategoryName("Category 1");

        when(placeCategoryMapping.getByIdPlaceCategory(category)).thenReturn(getByIdPlaceCategoryResponse);
        when(placeCategoryRepositories.findById(placeCategoryId)).thenReturn(Optional.of(category));

        Optional<GetByIdPlaceCategoryResponse> actualResponse = placeCategoryService.getByIdPlaceCategory(placeCategoryId);

        assertEquals(getByIdPlaceCategoryResponse.getCategoryName(), actualResponse.get().getCategoryName());

        verify(placeCategoryRepositories).findById(placeCategoryId);
    }
    @Test
    void getByPlaceCategoryId_whenPlaceCategoryDoesNotExist_thenReturnEmpty()
    {
        int placeCategoryId = 1;

        when(placeCategoryRepositories.findById(placeCategoryId)).thenReturn(Optional.empty());

        PlaceCategoryNotFoundException thrown = assertThrows(PlaceCategoryNotFoundException.class, () -> {
            placeCategoryService.getByIdPlaceCategory(placeCategoryId);
        });

        assertEquals(PlaceCategoryMessage.PLACE_CATEGORY_NOT_FOUND, thrown.getMessage());

        verify(placeCategoryRepositories).findById(placeCategoryId);
    }
    @Test
    void whenCreatePlaceCategory_shouldReturnCreatedPlaceCategory() {

        CreatePlaceCategoryRequest request = new CreatePlaceCategoryRequest();
        request.setCategoryName("Test Category");

        PlaceCategory placeCategory = new PlaceCategory();
        placeCategory.setId(1);
        placeCategory.setCategoryName("Test Category");

        when(placeCategoryMapping.createPlaceCategory(request)).thenReturn(placeCategory);

        when(placeCategoryRepositories.save(placeCategory)).thenReturn(placeCategory);

        CreatePlaceCategoryResponse response = placeCategoryService.createPlaceCategory(request);

        assertNotNull(response);
        assertEquals(1, response.getId());
        assertEquals("Test Category", response.getCategoryName());

        verify(placeCategoryMapping).createPlaceCategory(request);
        verify(placeCategoryRepositories).save(placeCategory);

    }
    @Test
    void updatePlaceCategory_whenValidRequest_thenUpdatePlaceCategorySuccessfully()
    {
        int placeCategoryId = 1;
        UpdatePlaceCategoryRequest request = new UpdatePlaceCategoryRequest();
        request.setCategoryName("Test Category");


        PlaceCategory placeCategory = new PlaceCategory();
        placeCategory.setId(placeCategoryId);
        placeCategory.setCategoryName("Test Category");

        when(placeCategoryMapping.updatePlaceCategory(request,placeCategory)).thenReturn(placeCategory);;
        when(placeCategoryRepositories.findById(placeCategoryId)).thenReturn(Optional.of(placeCategory));
        when(placeCategoryRepositories.save(placeCategory)).thenReturn(placeCategory);

        UpdatePlaceCategoryResponse response = placeCategoryService.updatePlaceCategory(request,placeCategoryId);

        assertNotNull(response);
        assertEquals(placeCategoryId, response.getId());
        assertEquals(request.getCategoryName(), response.getCategoryName());

        verify(placeCategoryRepositories).save(any(PlaceCategory.class));

    }
    @Test
    void updatePlaceCategory_whenIdIsNotFound_thenThrowEntityNotFoundException()
    {
        int placeCategoryId = 1;

        when(placeCategoryRepositories.findById(placeCategoryId)).thenReturn(Optional.empty());

        PlaceCategoryNotFoundException thrown = assertThrows(PlaceCategoryNotFoundException.class, () -> {
            placeCategoryService.getByIdPlaceCategory(placeCategoryId);
        });

        assertEquals(PlaceCategoryMessage.PLACE_CATEGORY_NOT_FOUND, thrown.getMessage());

        verify(placeCategoryRepositories).findById(placeCategoryId);

    }
    @Test
    void deletePlaceCategory_whenPlaceCategoryExists_thenDeletePlaceCategorySuccessfully() {
        int placeCategoryId = 1;
        PlaceCategory category = new PlaceCategory();
        category.setId(placeCategoryId);
        category.setCategoryName("Test Category");

        when(placeCategoryRepositories.findById(placeCategoryId)).thenReturn(Optional.of(category));

        placeCategoryService.deletePlaceCategory(placeCategoryId);

        verify(placeCategoryRepositories).deleteById(placeCategoryId);
    }
    @Test
    void deletePlaceCategory_whenPlaceCategoryDoesNotExist_thenThrowPlaceCategoryNotFoundException() {
        int placeCategoryId = 1;

        when(placeCategoryRepositories.findById(placeCategoryId)).thenReturn(Optional.empty());

        PlaceCategoryNotFoundException thrown = assertThrows(PlaceCategoryNotFoundException.class, () -> {
            placeCategoryService.deletePlaceCategory(placeCategoryId);
        });

        assertEquals(PlaceCategoryMessage.PLACE_CATEGORY_NOT_FOUND, thrown.getMessage());

        verify(placeCategoryRepositories).findById(placeCategoryId);
    }
}
