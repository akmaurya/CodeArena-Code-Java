package com.gps.spring.aop.client;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.gps.spring.aop.service.CustomerService;

public class CustomerServiceJoinPointClient {
	public static void main(String[] args) {
		ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("CustomerAppConfig.xml");
		CustomerService customerService = ctx.getBean("customerService", CustomerService.class);

		customerService.getCustomer().setName("Test Join point");
		customerService.getCustomer().setUrl("google.com");

//		System.out.println(customerService.getCustomer().getName());
//		System.out.println(customerService.getCustomer().getUrl());

		ctx.close();
	}
}
