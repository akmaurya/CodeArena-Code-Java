package com.gps.spring.aop.client;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.gps.spring.aop.dao.EmployeeManager;
import com.gps.spring.aop.pojo.EmployeeDTO;

public class EmployeeDaoAopClient {
	@SuppressWarnings("resource")
	public static void main(String[] args) {

		ApplicationContext context = new ClassPathXmlApplicationContext("EmployeeAppConfig.xml");
		EmployeeManager manager = (EmployeeManager) context.getBean("employeeManager");

		manager.getEmployeeById(1);

		manager.createEmployee(new EmployeeDTO());

		manager.deleteEmployee(100);
	}
}
