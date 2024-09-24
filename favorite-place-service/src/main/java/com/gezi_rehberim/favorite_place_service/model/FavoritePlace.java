package com.gezi_rehberim.favorite_place_service.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Document(collection = "favorite_places")
public class FavoritePlace {

    @Id
    private String id;
    private Place place;
    private User user;

}
