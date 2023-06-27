package com.src.java.constructor;

public class TestEmployeeClient {

	public static void main(String[] args) {
		// Initialize using Default Constructor
		Employee employee = new Employee();
		employee.setId("E000");
		employee.setName("Test");
		printEmplyoyeeDetails("Default Values----", employee);

		// Initialize using Parameterized Constructor Values
		employee = new Employee("E001", "Amit");
		employee.setAge(25);
		employee.setSalary(1220f);
		printEmplyoyeeDetails("Parameterized Constructor Values----", employee);

		// Initialize using Parameterized Overloaded Constructor's Values----
		employee = new Employee("E001", "Amit", 23, 5000);
		printEmplyoyeeDetails("Parameterized Overloaded Constructor's Values----", employee);
	}

	/**
	 * Method print employee details
	 * 
	 * @param title
	 * @param employee
	 */
	private static void printEmplyoyeeDetails(final String title, final Employee employee) {
		System.out.println(title);
		System.out.println(employee.getId() + "---" + employee.getName() + "---" + employee.getAge() + "---"
				+ employee.getSalary());
		System.out.println();
	}
}
