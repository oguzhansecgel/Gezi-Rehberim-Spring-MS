package com.gezi_rehberim.place_service.dto.response.placecategory;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class GetAllPlaceCategoryResponse {
    private int id;
    private String categoryName;
}
