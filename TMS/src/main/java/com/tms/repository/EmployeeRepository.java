package com.tms.repository;

import org.springframework.data.repository.CrudRepository;

import com.tms.model.Employee;

public interface EmployeeRepository extends CrudRepository<Employee,Integer> {
		
}
