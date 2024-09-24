package com.gezi_rehberim.favorite_place_service.repository;

import com.gezi_rehberim.favorite_place_service.model.FavoritePlace;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface FavoritePlaceRepositories extends MongoRepository<FavoritePlace, String> {
    List<FavoritePlace> findByUserId(int userId);
}
