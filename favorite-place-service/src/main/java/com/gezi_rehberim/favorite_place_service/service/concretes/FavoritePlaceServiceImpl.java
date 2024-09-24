package com.gezi_rehberim.favorite_place_service.service.concretes;

import com.gezi_rehberim.favorite_place_service.client.PlaceClient;
import com.gezi_rehberim.favorite_place_service.client.UserClient;
import com.gezi_rehberim.favorite_place_service.core.dto.response.favoriteplace.CreateFavoritePlaceResponse;
import com.gezi_rehberim.favorite_place_service.core.dto.response.favoriteplace.GetAllFavoritePlaceResponse;
import com.gezi_rehberim.favorite_place_service.core.exception.place.PlaceNotFoundException;
import com.gezi_rehberim.favorite_place_service.core.exception.user.UserNotFoundException;
import com.gezi_rehberim.favorite_place_service.core.mapper.FavoritePlaceMapper;
import com.gezi_rehberim.favorite_place_service.core.message.place.PlaceMessage;
import com.gezi_rehberim.favorite_place_service.core.message.user.UserMessage;
import com.gezi_rehberim.favorite_place_service.model.FavoritePlace;
import com.gezi_rehberim.favorite_place_service.model.Place;
import com.gezi_rehberim.favorite_place_service.model.User;
import com.gezi_rehberim.favorite_place_service.repository.FavoritePlaceRepositories;
import com.gezi_rehberim.favorite_place_service.service.abstracts.FavoritePlaceService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class FavoritePlaceServiceImpl implements FavoritePlaceService {


    private final FavoritePlaceRepositories favoritePlaceRepositories;
    private final PlaceClient placeClient;
    private final UserClient userClient;

    public FavoritePlaceServiceImpl(FavoritePlaceRepositories favoritePlaceRepositories, PlaceClient placeClient, UserClient userClient) {
        this.favoritePlaceRepositories = favoritePlaceRepositories;
        this.placeClient = placeClient;
        this.userClient = userClient;
    }

    @Override
    public CreateFavoritePlaceResponse createFavoritePlace(int userId,int placeId) {
        Optional<Place> place = placeClient.getPlaceById(placeId);
        Optional<User> user = userClient.getUserById(userId);
        if(place.isEmpty())
            throw new PlaceNotFoundException(PlaceMessage.PLACE_NOT_FOUND);
        if (user.isEmpty())
            throw new UserNotFoundException(UserMessage.USER_NOT_FOUND);
        Place getPlace =  place.get();
        User getUser = user.get();
        FavoritePlace favoritePlace = new FavoritePlace();
        favoritePlace.setPlace(getPlace);
        favoritePlace.setUser(getUser);
        favoritePlaceRepositories.save(favoritePlace);
        return new CreateFavoritePlaceResponse(favoritePlace.getId(),favoritePlace.getPlace(),favoritePlace.getUser());

    }

    @Override
    public List<GetAllFavoritePlaceResponse> getAllFavoritePlaces() {
        List<FavoritePlace> favoritePlaces = favoritePlaceRepositories.findAll();
        return FavoritePlaceMapper.INSTANCE.favoritePlaceToListFavoritePlace(favoritePlaces);
    }

    @Override
    public List<FavoritePlace> getAllFavoritePlacesByUserId(int userId) {
        return favoritePlaceRepositories.findByUserId(userId);
    }
}
