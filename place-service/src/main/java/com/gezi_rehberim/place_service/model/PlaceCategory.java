package com.gezi_rehberim.place_service.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "place_category")
@Entity
public class PlaceCategory extends BaseEntity{

    @Column(name = "category_name")
    private String categoryName;
    @OneToMany(mappedBy = "placeCategory")
    private List<Place> places;
}
