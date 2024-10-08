package com.gezi_rehberim.search_service.repositories;

import com.gezi_rehberim.search_service.document.Place;
import org.springframework.data.elasticsearch.annotations.Query;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PlaceRepositories extends ElasticsearchRepository<Place,String> {

    @Query("{\"wildcard\": {\"name\": \"*?0*\"}}")
    List<Place> searchByName(String name);
}
