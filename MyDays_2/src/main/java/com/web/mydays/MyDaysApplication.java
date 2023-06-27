package com.web.mydays;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;


@EnableJpaRepositories(basePackages = "com.web.mydays.repository")
@SpringBootApplication
public class MyDaysApplication extends SpringBootServletInitializer {

	public static void main(String[] args) {
		SpringApplication.run(MyDaysApplication.class, args);
	}

}
