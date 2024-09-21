package com.gezi_rehberim.place_service.dto.response.place;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class GetByPlaceWithPlaceCategoryResponse {
    private int id;

    private String name;

    private String description;

    private String address;

    private String category;

    private Double latitude;

    private Double longitude;

    private List<String> imageUrls;

    private int placeCategoryId;
}
