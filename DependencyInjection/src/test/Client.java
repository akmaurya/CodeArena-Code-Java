package test;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import beans.HelloUser;

public class Client {
	public static void main(String args[]){
		
		ApplicationContext context = new ClassPathXmlApplicationContext("resources/spring.xml");
		
		HelloUser t = (HelloUser)context.getBean("test");
		t.hello("Arvind");
	
	}
}
