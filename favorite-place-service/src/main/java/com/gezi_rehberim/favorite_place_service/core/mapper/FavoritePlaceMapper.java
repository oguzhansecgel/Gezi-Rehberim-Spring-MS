package com.gezi_rehberim.favorite_place_service.core.mapper;

import com.gezi_rehberim.favorite_place_service.core.dto.request.favoriteplace.CreateFavoritePlaceRequest;
import com.gezi_rehberim.favorite_place_service.core.dto.response.favoriteplace.GetAllFavoritePlaceResponse;
import com.gezi_rehberim.favorite_place_service.model.FavoritePlace;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface FavoritePlaceMapper {

    FavoritePlaceMapper INSTANCE = Mappers.getMapper(FavoritePlaceMapper.class);

    FavoritePlace createFavoritePlace(CreateFavoritePlaceRequest request);

    GetAllFavoritePlaceResponse getAllFavoritePlaces(FavoritePlace favoritePlace);
    List<GetAllFavoritePlaceResponse> favoritePlaceToListFavoritePlace(List<FavoritePlace> favoritePlaces);




}
