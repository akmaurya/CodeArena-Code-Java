package com.web.mydays;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan("com.web.mydays")
public class MyDaysApplication {

	public static void main(String[] args) {
		SpringApplication.run(MyDaysApplication.class, args);
	}

}
