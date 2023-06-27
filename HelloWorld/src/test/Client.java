package test;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import beans.Test;

public class Client {

	public static void main(String[] args) {
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("resources/spring.xml");
	
		Test t = (Test)context.getBean("t");
		t.hello();
	}

}
