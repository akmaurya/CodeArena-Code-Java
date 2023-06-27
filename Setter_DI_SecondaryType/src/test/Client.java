package test;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import beans.Car;

public class Client {
	public static void main(String[] a){
		String[] file =new  String[]{"resources/car.xml", "resources/engine.xml"};
		
		ApplicationContext context = new ClassPathXmlApplicationContext(file);
		
		Car car = (Car)context.getBean("car");
		car.printCarData();
		
	}
}
