package com.src.java.collection;


public class Employee implements Comparable<Employee> {
	private String name;
	private int salary;

	public Employee(String name, int salary) {
		this.name = name;
		this.salary = salary;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getSalary() {
		return salary;
	}

	public void setSalary(int salary) {
		this.salary = salary;
	}

	@Override
	public String toString() {
		return "Name: " + this.name + "-- Salary: " + this.salary;
	}
	
	@Override
	public int compareTo(Employee emp) {
		if(this.getSalary() > emp.getSalary()){
            return 1;
        } else {
            return -1;
        }
	}
}
