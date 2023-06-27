package com.gps.spring.ioc.dao;

import java.util.List;

import com.gps.spring.ioc.pojo.Employee;

public class EmployeeDAO {
	private List<Employee> employees;

	public List<Employee> getEmployees() {
		return employees;
	}

	public void setEmployees(List<Employee> employees) {
		this.employees = employees;
	}	
}
