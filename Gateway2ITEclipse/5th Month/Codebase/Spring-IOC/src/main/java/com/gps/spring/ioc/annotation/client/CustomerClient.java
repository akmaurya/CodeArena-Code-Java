package com.gps.spring.ioc.annotation.client;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.gps.spring.ioc.annotation.service.CustomerService;

public class CustomerClient {
	@SuppressWarnings("resource")
	public static void main(String[] args) {
		ApplicationContext context = new ClassPathXmlApplicationContext(new String[] { "annotation/AutoScanConfig.xml" });

		CustomerService cust = (CustomerService) context.getBean("customerService");
		System.out.println(cust);

	}
}
