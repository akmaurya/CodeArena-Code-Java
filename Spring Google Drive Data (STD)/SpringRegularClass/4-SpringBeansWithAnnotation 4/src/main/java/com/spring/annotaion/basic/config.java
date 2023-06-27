package com.spring.annotaion.basic;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Configuration
@ComponentScan("com.spring.annotaion.basic")
@PropertySource("file.properties")
public class config {

	@Bean(initMethod="initMethod",destroyMethod="destroyMethod")
	First First() {

		return new First();

	}
}
