package com.gps.spring.ioc.client;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.gps.spring.ioc.pojo.HelloWorld;

/**
 * 
 * HellowWorld using Application Context
 *
 */
public class HelloWorldClient {
	@SuppressWarnings("resource")
	public static void main(String[] args) {

		// To create application context.
		// This API loads beans configuration file and eventually based on the
		// provided API, it takes care of creating and initializing all the
		// objects i.e. beans mentioned in the configuration file.
		
		BeanFactory context = new ClassPathXmlApplicationContext(
				"HelloWorldConfig.xml");
		
//		ApplicationContext context = new ClassPathXmlApplicationContext(
//				"HelloWorldConfig.xml");

		HelloWorld obj = (HelloWorld) context.getBean("helloWorld");
		obj.getMessage();
		
		// Via p:schema
		obj = (HelloWorld) context.getBean("helloWorldViaPSchema");
		obj.getMessage();
	}
}
