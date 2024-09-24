package com.gezi_rehberim.favorite_place_service.model;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Place{

    private int id;

    private String name;

    private String description;

    private String address;

    private Double latitude;

    private Double longitude;
    private List<String> imageUrls;
    private int placeCategoryId;
}
