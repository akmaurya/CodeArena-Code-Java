package com.gps.spring.ioc.annotation.dao;

import java.util.List;

import com.gps.spring.ioc.pojo.Employee;

public class EmployeeDAO implements IEmployeeDAO {
	private List<Employee> employees;

	@Override
	public List<Employee> getEmployees() {
		return employees;
	}

	@Override
	public void setEmployees(List<Employee> employees) {
		this.employees = employees;
	}

	@Override
	public void displayEmployee() {
		System.out.println("Displaying Employee List....");
	}
}
