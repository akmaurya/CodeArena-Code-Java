package com.gps.spring.ioc.client;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.gps.spring.ioc.pojo.HelloWorld;

/**
 * Example to use multiple ids of single bean
 * 
 * @author GPS
 *
 */
public class BeanIdAndNameComparator {
	@SuppressWarnings("resource")
	public static void main(String[] args) {

		ApplicationContext context = new ClassPathXmlApplicationContext(
				"BeanPropertiesConfig.xml");

		HelloWorld obj1 = (HelloWorld) context.getBean("helloWorld1");
		obj1.getMessage();

		HelloWorld obj1a = (HelloWorld) context.getBean("alias1");
		obj1a.getMessage();

		HelloWorld obj2 = (HelloWorld) context.getBean("helloWorld2");
		obj2.getMessage();

		HelloWorld obj2a = (HelloWorld) context.getBean("alias2");
		obj2a.getMessage();

		if (obj1 == obj1a) {
			System.out
					.println("Instance & alias of same Bean refers same instance...");
		} else {
			System.out
					.println("Instance & alias of same Bean refers different instances...");
		}

		if (obj1 == obj2) {
			System.out.println("2 bean instances refers same instance...");
		} else {
			System.out
					.println("2 bean instances refers different instances...");
		}

		if (obj1a == obj2a) {
			System.out
					.println("Different alias of beans refers same instance...");
		} else {
			System.out
					.println("Different alias of beans refers different instance...");
		}

		HelloWorld obj1c = (HelloWorld) context.getBean("alias3");
		obj1c.getMessage();
		
		if (obj1a == obj1c) {
			System.out
					.println("Instance & alias of same Bean refers same instance...");
		} else {
			System.out
					.println("Instance & alias of same Bean refers different instances...");
		}

		HelloWorld obj5a = (HelloWorld) context.getBean("alias5");
		obj5a.getMessage();
	}
}
