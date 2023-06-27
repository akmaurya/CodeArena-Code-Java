package com.src.java.collection;

public class GPSEmployee implements Comparable<GPSEmployee> {
	String empId;
	String name;
	int age;

	public String getEmpId() {
		return empId;
	}

	public void setEmpId(String empId) {
		this.empId = empId;
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

	@Override
	public int compareTo(GPSEmployee emp) {
		return this.getEmpId().compareTo(emp.getEmpId());
	}
}
