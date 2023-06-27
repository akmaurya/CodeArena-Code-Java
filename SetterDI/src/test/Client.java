package test;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import beans.User;

public class Client {
	public static void main(String args[]){
		
		ApplicationContext context = new ClassPathXmlApplicationContext("resources/spring.xml");
		
		User t = (User)context.getBean("user");
		t.printData();
	
	}
}
