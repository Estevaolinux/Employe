package com.crve.crve;

import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootTest
@SpringBootApplication
@RestController
public class CrveApplicationTests {

	public static void main(String []args) { SpringApplication.run(CrveApplicationTests.class, args); }

	@GetMapping("/hello")
		public String hello (@RequestParam(value = "name", defaultValue = "World") String name) {
		return String.format("Hello %s!",name);
	}

}
