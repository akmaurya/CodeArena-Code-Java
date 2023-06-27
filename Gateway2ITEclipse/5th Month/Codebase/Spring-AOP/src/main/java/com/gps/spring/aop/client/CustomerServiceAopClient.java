package com.gps.spring.aop.client;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.gps.spring.aop.service.CustomerService;

public class CustomerServiceAopClient {
	public static void main(String[] args) {
		ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("CustomerConfig.xml");
		CustomerService customerService = ctx.getBean("customerService", CustomerService.class);

		System.out.println(customerService.getCustomer().getName());
		System.out.println(customerService.getCustomer().getUrl());

		ctx.close();
	}
}
