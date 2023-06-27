package test;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Test {
	public static void main(String[] arg){
		ApplicationContext ap = new ClassPathXmlApplicationContext("resources/spring.xml");
	}
}
