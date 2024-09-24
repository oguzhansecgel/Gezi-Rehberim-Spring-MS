package com.gezi_rehberim.favorite_place_service.client;

import com.gezi_rehberim.favorite_place_service.model.Place;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.Optional;

@FeignClient(name = "Place")
public interface PlaceClient {


    @GetMapping("api/place/getById/place/{id}")
    Optional<Place> getPlaceById(@PathVariable("id") int id);
}
