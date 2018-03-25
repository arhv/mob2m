package com.mob2m.hairdressing;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(exclude = org.springframework.boot.autoconfigure.security.SecurityAutoConfiguration.class)
//@EnableAutoConfiguration
public class InitialApplication {

	public static void main(String[] args) {
		SpringApplication.run(InitialApplication.class, args);

	}
}
