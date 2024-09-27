package com.gezi_rehberim.place_service.repositories;

import com.gezi_rehberim.place_service.model.PlaceCategory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PlaceCategoryRepositories extends JpaRepository<PlaceCategory, Integer> {
}
