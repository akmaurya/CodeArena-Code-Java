package com.gps.spring.aop.dao;

import java.util.List;

import com.gps.spring.aop.pojo.EmployeeDTO;

public interface EmployeeManager {
	public EmployeeDTO getEmployeeById(Integer employeeId);

	public List<EmployeeDTO> getAllEmployee();

	public void createEmployee(EmployeeDTO employee);

	public void deleteEmployee(Integer employeeId);

	public void updateEmployee(EmployeeDTO employee);
}
