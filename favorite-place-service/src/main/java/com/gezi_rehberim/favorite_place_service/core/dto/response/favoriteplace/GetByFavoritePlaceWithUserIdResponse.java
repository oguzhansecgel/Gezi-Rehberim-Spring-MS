package com.gezi_rehberim.favorite_place_service.core.dto.response.favoriteplace;
import com.gezi_rehberim.favorite_place_service.model.Place;
import com.gezi_rehberim.favorite_place_service.model.User;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class GetByFavoritePlaceWithUserIdResponse {
    private String id;
    private List<Place> place;
    private User user;
}
