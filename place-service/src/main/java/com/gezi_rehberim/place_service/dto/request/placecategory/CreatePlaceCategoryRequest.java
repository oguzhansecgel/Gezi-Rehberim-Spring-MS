package com.gezi_rehberim.place_service.dto.request.placecategory;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class CreatePlaceCategoryRequest {
    private String categoryName;
}
