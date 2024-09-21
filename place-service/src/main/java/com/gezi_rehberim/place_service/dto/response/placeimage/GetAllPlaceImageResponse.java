package com.gezi_rehberim.place_service.dto.response.placeimage;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class GetAllPlaceImageResponse {
    private int id;
    private String imageFile;

    private int placeId;
}