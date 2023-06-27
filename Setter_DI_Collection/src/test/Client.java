package test;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import beans.Collections;

public class Client {
	public static void main(String[] a){
		ApplicationContext context = new ClassPathXmlApplicationContext("resources/collections.xml");
		
		Collections collection = (Collections)context.getBean("collections");
		collection.displayCollections();
		
	}
}
