package com.src.java.io.file;

public class NonFinalizedClass {
	private String str;
	private Integer id;

	NonFinalizedClass(final String str, final Integer id) {
		this.str = new String(str);
		this.id = new Integer(5);
	}

	void display() {
		System.out.println("Object Intialized str[" + str + "] & id[" + id + "]");
	}
}
