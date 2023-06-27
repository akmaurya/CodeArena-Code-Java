package com.gps.spring.ioc.client;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.gps.spring.ioc.dao.SimpleBeanFactory;
import com.gps.spring.ioc.pojo.SimpleBean;

/**
 * 
 * @author GPS
 *
 */
public class ApplicationContextAwareClient {
	/**
	 * @param args
	 */
	@SuppressWarnings("resource")
	public static void main(String[] args) {

		System.out.println("Initializing ApplicationContext");
		ApplicationContext factory = new ClassPathXmlApplicationContext("app-aware-context.xml");
		System.out.println("ApplicationContext Initialized");

		SimpleBeanFactory simpleFactory = (SimpleBeanFactory) factory.getBean("simpleFactory");

		SimpleBean simple1 = simpleFactory.getSimpleBean();
		System.out.println(simple1 + "->" + simple1.getSimpleProp());

		SimpleBean simple2 = simpleFactory.getSimpleBean();
		System.out.println(simple2 + "->" + simple2.getSimpleProp());

		SimpleBean simple3 = simpleFactory.getSimpleBean();
		System.out.println(simple3 + "->" + simple3.getSimpleProp());
		
		if(simple1 == simple2) {
			System.out.println("1 & 2 are same references");
		} else if(simple2 == simple3) {
			System.out.println("2 & 3 are same references");
		} else {
			System.out.println("1 & 2 & 3 are not same references");
		}
	}
}
