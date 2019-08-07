package com.hakeembuchanan;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import org.springframework.beans.factory.annotation.Value;

@RestController
@RequestMapping("/api")
@SpringBootApplication
public class StarwarsApplication {

@Value("${endpoint}")
String endpoint;

RestTemplate restTemplate;
public StarwarsApplication(){
	restTemplate= new RestTemplate();
}
public static void main(String[] args) {
		SpringApplication.run(StarwarsApplication.class, args);

	}

	@GetMapping("/planets")
	public PlanetsDetails getPlanetDetails() {

		final PlanetsDetails responseBody = restTemplate.getForObject(
				endpoint, PlanetsDetails.class);
		return responseBody;
	}


}
