package com.gps.spring.ioc.client;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.gps.spring.ioc.pojo.Employee;

public class EmployeeClient {
	@SuppressWarnings("resource")
	public static void main(String[] args) {

		ApplicationContext context = new ClassPathXmlApplicationContext("EmployeeConfig.xml");

//		Employee employeeByNameAndEmail = (Employee) context.getBean("employeeByNameAndEmail");
//		System.out.println(employeeByNameAndEmail);
//
//		Employee employeeByIdAndName = (Employee) context.getBean("employeeByIdAndName");
//		System.out.println(employeeByIdAndName);
//
//		Employee employeeByIdAndAge = (Employee) context.getBean("employeeByIdAndAge");
//		System.out.println(employeeByIdAndAge);
//
//		Employee employeeByIdAndSalary = (Employee) context.getBean("employeeByIdAndSalary");
//		System.out.println(employeeByIdAndSalary);
//
//		Employee employeeByIndex = (Employee) context.getBean("employeeByIndex");
//		System.out.println(employeeByIndex);
//
//		Employee employeeByIdAndNameWithAddress = (Employee) context.getBean("employeeByIdAndNameWithAddress");
//		System.out.println(employeeByIdAndNameWithAddress);

		// Inner Bean
//		Employee employeeByIdAndNameWithInnerAddress = (Employee) context
//				.getBean("employeeByIdAndNameWithInnerAddress");
//		System.out.println(employeeByIdAndNameWithInnerAddress);
//
//		// By Idref
		Employee employeeByIdAndNameWithAddressByIdref = (Employee) context
				.getBean("employeeByIdAndNameWithAddressByIdref");
		System.out.println(employeeByIdAndNameWithAddressByIdref);
	}
}
