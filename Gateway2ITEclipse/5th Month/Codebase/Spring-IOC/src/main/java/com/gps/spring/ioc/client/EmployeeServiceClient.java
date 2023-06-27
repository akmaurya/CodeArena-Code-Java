package com.gps.spring.ioc.client;

import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.gps.spring.ioc.dao.EmployeeDAO;
import com.gps.spring.ioc.pojo.Employee;

public class EmployeeServiceClient {
	@SuppressWarnings({ "resource" })
	public static void main(String[] args) {

		ApplicationContext context = new ClassPathXmlApplicationContext("EmployeeConfig.xml");

		List<Employee> employeeList = ((EmployeeDAO) context.getBean("employeeDao")).getEmployees();
		for (Employee employee : employeeList) {
			System.out.println(employee);
		}
	}

}
