package com.src.java.g2it.programs;

import java.util.Scanner;

public class StringArray {
	@SuppressWarnings("resource")
	public static void main(String[] args) {
		// Class is used to read input from user
		Scanner in = new Scanner(System.in);
		
		System.out.println("Enter your name:");
		String name = in.nextLine();
		
		System.out.println("Enter your age:");
		int age = in.nextInt();
		
		System.out.println("Name [" + name + "] & Age [" + age + "]");
	}
}
