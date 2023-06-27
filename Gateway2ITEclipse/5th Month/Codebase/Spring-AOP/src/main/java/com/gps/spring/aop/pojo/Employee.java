package com.gps.spring.aop.pojo;

import com.gps.spring.aop.aspect.Loggable;

public class Employee {
	private String name;

	public String getName() {
		return name;
	}

	// create a custom annotation and annotate the methods where we want the
	// advice to be applied.
	@Loggable
	public void setName(String name) {
		this.name = name;
	}

	public void throwException() {
		throw new RuntimeException("Dummy Exception");
	}
}
