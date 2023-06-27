package com.tms;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@EnableJpaAuditing
@SpringBootApplication
public class TMSApplication {

	public static void main(String[] args) {
		SpringApplication.run(TMSApplication.class, args);
	}

}
