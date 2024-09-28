package com.gezi_rehberim.favorite_place_service.controller;

import com.gezi_rehberim.favorite_place_service.core.dto.response.favoriteplace.CreateFavoritePlaceResponse;
import com.gezi_rehberim.favorite_place_service.core.dto.response.favoriteplace.GetAllFavoritePlaceResponse;
import com.gezi_rehberim.favorite_place_service.model.FavoritePlace;
import com.gezi_rehberim.favorite_place_service.service.abstracts.FavoritePlaceService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/favoriPlace")
public class FavoriPlaceController {

    private final FavoritePlaceService favoritePlaceService;

    public FavoriPlaceController(FavoritePlaceService favoritePlaceService) {
        this.favoritePlaceService = favoritePlaceService;
    }

    @GetMapping("/getAll/favoritePlace")
    public List<GetAllFavoritePlaceResponse> getAllFavoritePlaceResponse()
    {
        return favoritePlaceService.getAllFavoritePlaces();
    }
    @GetMapping("/getFavoriPlaceWithUser/{userId}")
    public List<FavoritePlace> favoritePlaceWithUser(@PathVariable int userId)
    {
        return favoritePlaceService.getAllFavoritePlacesByUserId(userId);
    }
    @PostMapping("/create/favoriPlace/{placeId}/{userId}")
    public CreateFavoritePlaceResponse createFavoriPlace(@PathVariable int userId, @PathVariable int placeId)
    {
        return favoritePlaceService.createFavoritePlace(userId, placeId);
    }
    @DeleteMapping("/delete/favoritePlace/{favoritePlaceId}")
    public void deleteFavoritePlace(@PathVariable String favoritePlaceId)
    {
        favoritePlaceService.removeFavoritePlace(favoritePlaceId);
    }
}
