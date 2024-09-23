package com.gezi_rehberim.favorite_place_service.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class User extends BaseEntity{

    private String password;
    private String email;
    private int roleId;
}
