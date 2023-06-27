package com.spring.annotaion.basic;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;

//@Component("first")
@Controller
public class First {

	@Autowired
	Second secondClass;

	@Value("${key}")
	String propertyKey;

	public void firstFunc() {
		System.out.println("firstClass");
		System.out.println("property key " + propertyKey);

		// secondClass.secFunc();
	}

	public void initMethod() {
		System.out.println("init is working.");
	}

	public void destroyMethod() {
		System.out.println("destroy is working.");
	}

}
