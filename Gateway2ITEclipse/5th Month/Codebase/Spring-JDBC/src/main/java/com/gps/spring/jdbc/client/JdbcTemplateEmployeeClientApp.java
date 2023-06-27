package com.gps.spring.jdbc.client;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.gps.spring.jdbc.dao.EmployeeDaoJdbcTemplateImpl;

public class JdbcTemplateEmployeeClientApp {
	@SuppressWarnings("resource")
	public static void main(String[] args) {
		ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("Spring-dao.xml");
		EmployeeDaoJdbcTemplateImpl dao = ctx.getBean("employeeDaoJdbcTemplateImpl", EmployeeDaoJdbcTemplateImpl.class);

		System.out.println("Employee count -" + dao.getEmployeeCount());
		System.out.println("Employee Name -" + dao.getEmployeeName("2") + " Id is [2]");
		System.out.println("EmployeeById [GPS0011] is - " + dao.getEmployee("2"));
		
//		System.out.println("Employee List are-");
//		for (Employee emp : dao.getEmployeeList()) {
//			System.out.println(emp);
//		}

//		String empId = "2014";
//		dao.addEmployee(new Employee(empId, "23", 233.44f, 31));
//		System.out.println("EmployeeById [" + empId + "] is - " + dao.getEmployee(empId));

//		String empId = "1223";
//		dao.addEmployeeWithNamedParameter(new Employee(empId, "12", 233.44f, 31));
//		System.out.println("EmployeeById [" + empId + "] is - " + dao.getEmployee(empId));
	}
}
