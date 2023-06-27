package com.src.java.polymorphism.runtime;

public class Parent {
	@SuppressWarnings("unused")
	private int age;
	@SuppressWarnings("unused")
	private float salary;

	void abc() {
		System.out.println("Parent: Inside abc without parameter...");
	}

	void abc(final int a) {
		System.out.println("Parent: Inside abc with parameter...[" + a + "]");
	}
}
