package com.gezi_rehberim.place_service.dto.request.place;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class UpdatePlaceRequest {

    private String name;

    private String description;

    private String address;

    private Double latitude;

    private Double longitude;

    private int placeCategoryId;
}
