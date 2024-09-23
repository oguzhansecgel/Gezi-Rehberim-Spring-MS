package com.gezi_rehberim.place_service.core.service.abstracts;

import org.springframework.web.multipart.MultipartFile;

import java.util.List;


public interface PlaceImageService {
    List<String> savePlaceImages(List<MultipartFile> imageFiles);
    void deletedImage(List<String> imageUrls);

}
