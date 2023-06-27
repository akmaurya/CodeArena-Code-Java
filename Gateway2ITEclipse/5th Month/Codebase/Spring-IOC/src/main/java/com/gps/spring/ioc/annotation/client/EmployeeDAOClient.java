package com.gps.spring.ioc.annotation.client;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Configuration;

import com.gps.spring.ioc.annotation.dao.IEmployeeDAO;

@Configuration
public class EmployeeDAOClient {
	@SuppressWarnings("resource")
	public static void main(String[] args) {

		ApplicationContext context = new AnnotationConfigApplicationContext(ApplicationConfiguration.class);
		IEmployeeDAO employeeDAO = (IEmployeeDAO) context.getBean("employeeDAO");

		employeeDAO.displayEmployee();
	}
}
