package com.gps.spring.ioc.annotation.dao;

import java.util.List;

import com.gps.spring.ioc.pojo.Employee;

public interface IEmployeeDAO {
	public List<Employee> getEmployees();
	public void setEmployees(List<Employee> employees);
	public void displayEmployee();
}
