package com.gezi_rehberim.place_service.dto.response.place;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class CreatePlaceResponse {

    private int id;

    private String name;

    private String description;

    private String address;

    private Double latitude;

    private Double longitude;
    private int placeCategoryId;
}
