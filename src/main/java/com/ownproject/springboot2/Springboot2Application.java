package com.ownproject.springboot2;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Springboot2Application {

	// Ezen nyomj egy start-ot. Az első indításkor létre fog hozni egy rakás fájlt.
	// http://localhost:8080/
	// Leállítás: terminálban ctrl+c
	public static void main(String[] args) {
		SpringApplication.run(Springboot2Application.class, args);
	}

}
