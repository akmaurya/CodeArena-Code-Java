package com.gps.spring.jdbc.client;

import com.gps.spring.jdbc.dao.EmployeeDaoImplNoSpring;
import com.gps.spring.jdbc.model.Employee;

public class EmployeeClientAppNoSpring {
	public static void main(String[] args) {
		EmployeeDaoImplNoSpring empDao = new EmployeeDaoImplNoSpring();
		for(Employee emp : empDao.getEmployeeList()) {
			System.out.println("Employee Record is - " + emp);
		}
	}
}
