package com.src.java.g2it.programs;

import java.util.Scanner;

public class GenerateTriangle {
	@SuppressWarnings("resource")
	public static void main(String[] args) {
		Scanner in;
		in = new Scanner(System.in);
		
		System.out.println("Enter size for traingle - ");
		int size = in.nextInt();
		
		for(int rowIndex=1; rowIndex<=size; rowIndex++) {
			for(int spaceIndex=1; spaceIndex<rowIndex; spaceIndex++) {
				System.out.print(" ");
			}
			for(int colIndex=1; colIndex<=(size+1 - (rowIndex*2)); colIndex++) {
				System.out.print("*");
			}
			System.out.println();
		}
	}
}
