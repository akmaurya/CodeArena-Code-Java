package com.src.java.constructor;

public class Employee {
	private String id;
	private String name;
	private int age;
	private float salary;

	// Default Constructor
	Employee() {
		// provide default values
		this.age = 40;
		this.salary = 10000f;
	}

	// Parameterized constructor OR Constructor is Overloaded
	Employee(final String id, final String name) {
		this.id = id;
		this.name = name;
	}

	// Parameterized overloaded constructor
	Employee(final String id, final String name, final int age, final float salary) {
		this(id, name);
		this.age = age;
		this.salary = salary;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
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

	public float getSalary() {
		return salary;
	}

	public void setSalary(float salary) {
		this.salary = salary;
	}
}
