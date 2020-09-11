package com.mn.newclient;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

@EnableCaching
@SpringBootApplication
public class NewclientApplication {

	public static void main(String[] args) {
		SpringApplication.run(NewclientApplication.class, args);
	}

}
