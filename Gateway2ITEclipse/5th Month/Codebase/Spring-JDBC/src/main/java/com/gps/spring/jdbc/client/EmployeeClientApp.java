package com.gps.spring.jdbc.client;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.gps.spring.jdbc.dao.EmployeeDaoImpl;
import com.gps.spring.jdbc.model.Employee;

public class EmployeeClientApp {
	@SuppressWarnings("resource")
	public static void main(String[] args) {
		ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("Spring-dao.xml");
		EmployeeDaoImpl dao = ctx.getBean("employeeDaoImpl", EmployeeDaoImpl.class);
		
		for(Employee emp : dao.getEmployeeList()) {
			System.out.println("Employee Record is - " + emp);
		}
	}
}
