package com.gezi_rehberim.comment_service;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.turkcell.tcell.exception.annotations.EnableException;

@SpringBootApplication
@EnableFeignClients
@EnableException
public class CommentServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(CommentServiceApplication.class, args);
	}

}
