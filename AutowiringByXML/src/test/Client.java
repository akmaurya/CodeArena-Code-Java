package test;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import beans.Car;

public class Client {
	public static void main(String[] a){
		ApplicationContext context = new ClassPathXmlApplicationContext("resources/spring.xml");
		
		Car car = (Car)context.getBean("car");
		car.printData();
		
	}
}
