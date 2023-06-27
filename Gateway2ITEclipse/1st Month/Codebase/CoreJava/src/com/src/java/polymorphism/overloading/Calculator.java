package com.src.java.polymorphism.overloading;

public class Calculator {
	public void add(int x, int y) {
		System.out.println(x + y);
	}
	
	public void add(int x, int y, int z) {
		System.out.println(x + y + z);
	}

	public void add(float x, float y) {
		System.out.println(x + y);
	}

	public long add(long x, long y) {
		return (x + y);
	}

	public static void main(String args[]) {
		Calculator obj = new Calculator();
		obj.add(10, 20);
		obj.add(10, 20, 30);
		obj.add(10.1f, 20.2f);
		obj.add(10l, 20l);
	}
}
