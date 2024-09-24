package com.gezi_rehberim.favorite_place_service.service.abstracts;

import com.gezi_rehberim.favorite_place_service.core.dto.response.favoriteplace.CreateFavoritePlaceResponse;
import com.gezi_rehberim.favorite_place_service.core.dto.response.favoriteplace.GetAllFavoritePlaceResponse;
import com.gezi_rehberim.favorite_place_service.model.FavoritePlace;

import java.util.List;

public interface FavoritePlaceService {

    CreateFavoritePlaceResponse createFavoritePlace(int userId,int placeId);
    List<GetAllFavoritePlaceResponse> getAllFavoritePlaces();
    List<FavoritePlace> getAllFavoritePlacesByUserId(int userId);
}
