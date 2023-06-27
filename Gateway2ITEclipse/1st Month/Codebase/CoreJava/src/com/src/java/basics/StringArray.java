package com.src.java.basics;

import java.util.Scanner;

public class StringArray {
	public static void main(String[] args) {
		// Class is used to read input from user
		Scanner in = new Scanner(System.in);
		
		// Instantiate double dimensional string array
		String stringArray[][] = new String[2][];
		
		for(int rowIndex = 0; rowIndex < 2; rowIndex++) {
			stringArray[rowIndex] = new String[2];
			System.out.println("Enter a string [" + rowIndex + "] [0] :");
			stringArray[rowIndex][0] = in.nextLine();
			System.out.println("Enter a string [" + rowIndex + "] [1] :");
			stringArray[rowIndex][1] = in.nextLine();
		}
		
		System.out.println();
		for(int rowIndex = 0; rowIndex < 2; rowIndex++) {			
			System.out.print("Entered string at [" + rowIndex + "]  row :" + stringArray[rowIndex][0]);
			System.out.print("----");
			System.out.print(stringArray[rowIndex][1]);
			System.out.println();
		}
	}
}
