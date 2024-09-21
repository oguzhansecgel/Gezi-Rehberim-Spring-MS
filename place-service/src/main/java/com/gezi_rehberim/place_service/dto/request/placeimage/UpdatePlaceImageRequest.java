package com.gezi_rehberim.place_service.dto.request.placeimage;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.web.multipart.MultipartFile;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class UpdatePlaceImageRequest {
    private MultipartFile imageFile;

    private int placeId;
}
