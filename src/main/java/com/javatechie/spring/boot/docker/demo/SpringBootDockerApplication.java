package com.javatechie.spring.boot.docker.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class SpringBootDockerApplication {

	@GetMapping("/check")
	public String getMessage() {
		return "Welcome to Sandy SpringBoot !!";
	}

	public static void main(String[] args) {
		SpringApplication.run(SpringBootDockerApplication.class, args);
	}

	@GetMapping("/")
	public String getRoot() {
		return "Root  of Spring Boot Application !!";
	}

	@GetMapping("/api")
	public String getApi() {
		return "Api Called , call  /api/users to get  list of users";
	}

}
