package com.gps.spring.jdbc.model;

public class Employee {
	private String empId;
	private String empName;
	private float empSalary;
	private int empAge;

	public Employee() {
	}

	public Employee(String empId, String empName, float empSalary, int empAge) {
		this.empId = empId;
		this.empName = empName;
		this.empSalary = empSalary;
		this.empAge = empAge;
	}

	public String getEmpId() {
		return empId;
	}

	public void setEmpId(String empId) {
		this.empId = empId;
	}

	public String getEmpName() {
		return empName;
	}

	public void setEmpName(String empName) {
		this.empName = empName;
	}

	public float getEmpSalary() {
		return empSalary;
	}

	public void setEmpSalary(float empSalary) {
		this.empSalary = empSalary;
	}

	public int getEmpAge() {
		return empAge;
	}

	public void setEmpAge(int empAge) {
		this.empAge = empAge;
	}

	@Override
	public String toString() {
		return "EmpId [" + empId + "] Name [" + empName + "] Salary [" + empSalary + "] Age [" + empAge + "]";
	}
}
