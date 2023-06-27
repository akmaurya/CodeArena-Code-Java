package com.src.java.io.serialization;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

public class GpsEmployee extends Address implements Serializable{
	private static final long serialVersionUID = 1L;
	private String id;
	private String name;
	private int age;
	private float salary;

	// Default Constructor
	GpsEmployee() {
		// provide default values
		this.age = 40;
		this.salary = 10000f;
	}

	// Parameterized constructor
	GpsEmployee(final String id, final String name) {
		this.id = id;
		this.name = name;
	}

	// Parameterized overloaded constructor
	GpsEmployee(final String id, final String name, final int age,
			final float salary) {
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
	
	private void writeObject(ObjectOutputStream out) throws IOException {
		out.defaultWriteObject();
		out.writeObject(getFlatNo());
		out.writeObject(getCity());
	}

	private void readObject(ObjectInputStream in) throws IOException,
			ClassNotFoundException {
		in.defaultReadObject();
		setFlatNo((String) in.readObject());
		setCity((String) in.readObject());
	}
}
