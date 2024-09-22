package com.gezi_rehberim.search_service.repositories;

import com.gezi_rehberim.search_service.document.Place;
import org.springframework.data.elasticsearch.annotations.Query;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

import java.util.List;

public interface PlaceRepository extends ElasticsearchRepository<Place,Integer> {

    @Query("{\"wildcard\": {\"name\": \"*?0*\"}}")
    List<Place> searchByName(String name);
}
