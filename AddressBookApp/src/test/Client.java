package test;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import beans.AddressBean;
import beans.AddressBean;

public class Client {

	public static void main(String[] args) {
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("resources/spring.xml");
	
		AddressBean t = (AddressBean)context.getBean("t");
		t.hello();
	}

}
