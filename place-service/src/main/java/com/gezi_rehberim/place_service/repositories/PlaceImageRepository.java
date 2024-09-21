package com.gezi_rehberim.place_service.repositories;

import com.gezi_rehberim.place_service.model.PlaceImage;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PlaceImageRepository extends JpaRepository<PlaceImage, Integer> {
    List<PlaceImage> findByPlaceId(int placeId);
}
