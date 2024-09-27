package com.gezi_rehberim.place_service.repositories;

import com.gezi_rehberim.place_service.model.Place;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PlaceRepositories extends JpaRepository<Place, Integer> {

    List<Place> findAllByPlaceCategoryId(int placeCategoryId);
}
