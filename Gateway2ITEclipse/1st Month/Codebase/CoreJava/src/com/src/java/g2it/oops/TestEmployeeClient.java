package com.src.java.g2it.programs.oops;

import java.util.Date;

public class TestEmployeeClient {
	public static void main(String[] args) {
		Employee emp1 = new Employee();
		emp1.setId(4);
		emp1.setName("Amit");
		emp1.setDob(new Date(1980, 03, 03));
		emp1.setStreet("aaa");
		emp1.setState("AAAA");

		EmployeeType employeeType = new EmployeeType();
		employeeType.setTypeCode(1);
		employeeType.setTypeDesc("HR dskjsdsdkjkjsd");
		emp1.setEmployeeType(employeeType);
		
		Employee emp2 = new Employee(5, "Mannu", 20, new Date(1995, 04, 5), "ghat", "varanasi", "u.p", "india");
		employeeType = new EmployeeType();
		employeeType.setTypeCode(3);
		employeeType.setTypeDesc("Student");
		emp2.setEmployeeType(employeeType);

		printEmployee(emp1);
		printEmployee(emp2);
	}

	private static void printEmployee(Employee emp) {
		System.out.println(emp.getId() + "---" + emp.getName() + emp.getDob() + "---" + emp.getStreet()
				+ emp.getState() + emp.getEmployeeType().getTypeCode() + "---" + emp.getEmployeeType().getTypeDesc());
	}
}
