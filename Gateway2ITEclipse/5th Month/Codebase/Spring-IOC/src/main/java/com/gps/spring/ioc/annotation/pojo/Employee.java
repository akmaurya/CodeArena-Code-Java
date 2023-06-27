package com.gps.spring.ioc.annotation.pojo;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Required;

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

	public int getId() {
		return id;
	}

	@Required
	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	@Required
	public void setName(String name) {
		this.name = name;
	}

	public Address getAddress() {
		return address;
	}

	@Required
	@Autowired
	@Qualifier(value = "myaddress")
	public void setAddress(Address address) {
		this.address = address;
	}

	@PostConstruct
	public void init() {
		System.out.println("Employee Bean is going through init.");
	}

	@PreDestroy
	public void destroy() {
		System.out.println("Employee Bean will destroy now.");
	}

	@Override
	public String toString() {
		return "Id [" + id + "], Name [" + name + "], Email [" + email + "], Age [" + age + "], Salary [" + salary
				+ "]" + (address != null ? " & " + address : "");
	}
}
