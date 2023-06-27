package com.src.java.cloning;

public class CreateEmployeeClone {
	public static void main(String[] args) throws CloneNotSupportedException {
		Department dept = new Department(1, "Human Resource");
		Employee emp = new Employee(1, "Admin", dept);
		
		// Lets create a clone of original object
		Employee clonedEmp = (Employee) emp.clone();
		// Let verify using employee id, if cloning actually worked
		System.out.println("ID: " + clonedEmp.getEmpoyeeId());

		// Verify JDK's rules

		// Must be true and objects must have different memory addresses
		System.out.println("Objects have different memory addresses: " + (emp != clonedEmp));

		// As we are returning same class; so it should be true
		System.out.println("Same class: " + (emp.getClass() == clonedEmp.getClass()));

		// Default equals method checks for references so it should be false. If
		// we want to make it true,
		// we need to override equals method in Employee class.
		System.out.println("Both Object are Equals: " + (emp.equals(clonedEmp)));
	}
}
