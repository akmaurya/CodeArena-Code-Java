package com.src.java.g2it.programs.oops;

import java.util.Date;

public class Employee extends Address {
	private int id;
	private String name;
	private int age;
	private Date dob;
	private Date doj;
	private String designation;
	private EmployeeType employeeType;

	Employee() {
		super();
	}

	Employee(int id, String name, String street, String city, String state, String country) {
		super(street, city, state, country);
		this.id = id;
		this.name = name;
	}

	Employee(int id, String name, int age, Date dob, String street, String city, String state, String country) {
		this(id, name, street, city, state, country);
		this.age = age;
		this.dob = dob;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public Date getDob() {
		return dob;
	}

	public void setDob(Date dob) {
		this.dob = dob;
	}

	public Date getDoj() {
		return doj;
	}

	public void setDoj(Date doj) {
		this.doj = doj;
	}

	public String getDesignation() {
		return designation;
	}

	public void setDesignation(String designation) {
		this.designation = designation;
	}

	public EmployeeType getEmployeeType() {
		return employeeType;
	}

	public void setEmployeeType(EmployeeType employeeType) {
		this.employeeType = employeeType;
	}
}
