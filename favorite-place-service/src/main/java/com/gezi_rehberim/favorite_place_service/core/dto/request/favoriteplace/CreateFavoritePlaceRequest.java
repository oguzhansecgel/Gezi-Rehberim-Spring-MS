package com.gezi_rehberim.favorite_place_service.core.dto.request.favoriteplace;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class CreateFavoritePlaceRequest {
    private int placeId;
    private int userId;
}
