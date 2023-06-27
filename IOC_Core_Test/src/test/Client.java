package test;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import beans.Test;

public class Client {
	public static void main(String args[]){
		//ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("resource/spring.xml");
		ApplicationContext context = new ClassPathXmlApplicationContext("resource/spring.xml");
		
		Test t = (Test)context.getBean("test");
		System.out.println("Document Valid");
	
	}
}
