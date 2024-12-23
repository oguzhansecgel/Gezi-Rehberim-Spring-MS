package com.gezi_rehberim.place_service.dto.request.place;

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
public class CreatePlaceRequest {
    private String name;

    private String description;

    private String address;

    private Double latitude;

    private Double longitude;
    private List<MultipartFile> imageUrls;
    private int placeCategoryId;

    @Override
    public String toString() {
        return "CreatePlaceRequest{" +
                "name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", address='" + address + '\'' +
                ", latitude=" + latitude +
                ", longitude=" + longitude +
                ", imageUrls=" + imageUrls +
                ", placeCategoryId=" + placeCategoryId +
                '}';
    }
}
