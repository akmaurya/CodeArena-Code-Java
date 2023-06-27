package com.gps.spring.ioc.client;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.gps.spring.ioc.pojo.HelloWorld;

public class PrototypeScopeExample {
	@SuppressWarnings("resource")
	public static void main(String[] args) {
		ApplicationContext context = new ClassPathXmlApplicationContext("BeanScopeConfig.xml");

		HelloWorld objA = (HelloWorld) context.getBean("helloWorldPrototype");

		objA.setMessage("I'm object A");
		objA.getMessage();

		HelloWorld objB = (HelloWorld) context.getBean("helloWorldPrototype");
		objB.getMessage();
		
		if(objA == objB) {
			System.out.println("references are same...");
		} else {
			System.out.println("references are not same...");
		}
		
		if(objA.equals(objB)) {
			System.out.println("objects are equals...");
		} else {
			System.out.println("objects are not equals...");
		}
	}
}
