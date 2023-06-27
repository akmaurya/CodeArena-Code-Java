package com.tms.service;

import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import com.tms.model.Employee;
import com.tms.repository.EmployeeRepository;

@Service
@Transactional
public class EmployeeService {
	
	public final EmployeeRepository employeeRepository;
	
	public EmployeeService(EmployeeRepository employeeRepository) {
		super();
		this.employeeRepository = employeeRepository;
	}

	public void saveEmployee(Employee employee) {
		employeeRepository.save(employee);
	}
		
}
