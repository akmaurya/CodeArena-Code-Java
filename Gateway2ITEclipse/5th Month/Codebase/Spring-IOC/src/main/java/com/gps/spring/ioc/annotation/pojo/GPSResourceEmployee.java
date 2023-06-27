package com.gps.spring.ioc.annotation.pojo;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Required;

/**
 * Employee pojo
 * 
 * @author GPS
 *
 */
public class GPSResourceEmployee {
	private int id;
	private String name;
	private String email;
	private int age;
	private float salary;
	@Resource (name = "gpsaddressForResouce")
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

	@Override
	public String toString() {
		return "Id [" + id + "], Name [" + name + "], Email [" + email + "], Age [" + age + "], Salary [" + salary
				+ "]" + (address != null ? " & " + address : "");
	}
}
