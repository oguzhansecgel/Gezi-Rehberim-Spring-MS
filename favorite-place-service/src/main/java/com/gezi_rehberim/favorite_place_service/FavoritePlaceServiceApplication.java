package com.gezi_rehberim.favorite_place_service;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.turkcell.tcell.exception.annotations.EnableException;

@SpringBootApplication
@EnableFeignClients
@EnableException
public class FavoritePlaceServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(FavoritePlaceServiceApplication.class, args);
	}

}
