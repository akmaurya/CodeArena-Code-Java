package com.gps.spring.jdbc.client;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.gps.spring.jdbc.dao.NamedParameterJdbcDaoImpl;

public class JdbcDaoSupportEmployeeClientApp {
	@SuppressWarnings("resource")
	public static void main(String[] args) {
		ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("Spring-dao.xml");
		NamedParameterJdbcDaoImpl dao = ctx.getBean("namedParameterJdbcDaoImpl", NamedParameterJdbcDaoImpl.class);

		String empId = "1222";
		System.out.println("EmployeeById [" + empId + "] is - " + dao.getEmployee(empId));
		
		empId = "2";
		System.out.println("EmployeeById [" + empId + "] is - " + dao.getEmployeeUsingBeanPropertyRowMapper(empId));
	}
}
