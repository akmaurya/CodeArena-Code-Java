package com.src.java.wrappers;

public class AutoBoxUnBox {
	public static void main(String args[]) {
		Integer integerX = 5; // boxes int to an Integer object
		int intX = integerX + 10; // unboxes the Integer to a int
		System.out.println(integerX);
		System.out.println(intX);
	}
}
