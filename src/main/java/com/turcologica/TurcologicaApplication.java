package com.turcologica;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
public class TurcologicaApplication {

	public static void main(String[] args) {
		SpringApplication.run(TurcologicaApplication.class, args);
	}
}
