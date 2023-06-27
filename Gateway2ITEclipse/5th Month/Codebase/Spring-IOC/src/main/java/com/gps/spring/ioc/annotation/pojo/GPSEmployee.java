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
public class GPSEmployee {
	private int id;
	private String name;
	private String email;
	private int age;
	private float salary;
	private Address address;

	@Autowired
	public GPSEmployee(@Qualifier(value = "gpsaddress") Address address) {
		this.address = address;
	}

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

	@PostConstruct
	public void init() {
		System.out.println("GPSEmployee Bean is going through init.");
	}

	@PreDestroy
	public void destroy() {
		System.out.println("GPSEmployee Bean will destroy now.");
	}

	@Override
	public String toString() {
		return "Id [" + id + "], Name [" + name + "], Email [" + email + "], Age [" + age + "], Salary [" + salary
				+ "]" + (address != null ? " & " + address : "");
	}
}
