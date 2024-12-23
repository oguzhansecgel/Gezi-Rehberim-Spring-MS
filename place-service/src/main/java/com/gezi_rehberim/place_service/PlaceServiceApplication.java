package com.gezi_rehberim.place_service;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.turkcell.tcell.exception.annotations.EnableException;

@SpringBootApplication
@EnableException
@EnableCaching
public class PlaceServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(PlaceServiceApplication.class, args);
	}

}
