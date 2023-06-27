package com.gps.spring.ioc.client;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.gps.spring.ioc.pojo.Customer;

public class BeanDefinitionClient {
	@SuppressWarnings("resource")
	public static void main(String[] args) {
		ApplicationContext context = new ClassPathXmlApplicationContext("bean-inheritence-context.xml");

		Customer cust = (Customer) context.getBean("CustomerBeanAddList");
		System.out.println(cust);

		cust = (Customer) context.getBean("CustomerBeanOverrideList");
		System.out.println(cust);

		// If try to call template bean the ERROR come: Error creating bean with
		// name 'BaseCustomerMalaysia': Bean definition is abstract
//		cust = (Customer) context.getBean("BaseCustomerMalaysia");
//		System.out.println(cust);
	}
}
