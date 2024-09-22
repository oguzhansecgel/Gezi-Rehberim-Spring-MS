package com.gezi_rehberim.search_service.document;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;

@Getter
@Setter
@Document(indexName = "place")
@AllArgsConstructor
@NoArgsConstructor
public class Place {
    @Id
    private int id;
    private String name;
    private String description;
    private String address;
    private Double latitude;
    private Double longitude;

}
