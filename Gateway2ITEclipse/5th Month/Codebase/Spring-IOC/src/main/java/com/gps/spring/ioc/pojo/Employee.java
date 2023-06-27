package com.gps.spring.ioc.pojo;

/**
 * Employee pojo
 * 
 * @author GPS
 *
 */
public class Employee {
	private int id;
	private String name;
	private String email;
	private int age;
	private float salary;
	private Address address;

	public Employee(int id, String name) {
		this.id = id;
		this.name = name;
	}

	public Employee(int id, int age) {
		this.id = id;
		this.age = age;
	}

	public Employee(int id, float salary) {
		this.id = id;
		this.salary = salary;
	}

	public Employee(String name, String email) {
		this.name = name;
		this.email = email;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

	@Override
	public String toString() {
		return "Id [" + id + "], Name [" + name + "], Email [" + email + "], Age [" + age + "], Salary [" + salary
				+ "]" + (address != null ? " & " + address : "");
	}
}
