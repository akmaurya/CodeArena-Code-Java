package com.gps.spring.aop.client;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.gps.spring.aop.service.EmployeeService;

public class EmployeeServiceAopClient {
	public static void main(String[] args) {
		ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("EmployeeConfig.xml");
		EmployeeService employeeService = ctx.getBean("employeeService", EmployeeService.class);

		System.out.println(employeeService.getEmployee().getName());

		employeeService.getEmployee().setName("Pankaj");

		employeeService.getEmployee().throwException();

		ctx.close();
	}
}
