package com.rhc;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@EnableScheduling
@SpringBootApplication
public class RhcApplication {

	public static void main(String[] args) {
		SpringApplication.run(RhcApplication.class, args);
	}

}
