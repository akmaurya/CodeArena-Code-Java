package com.src.java.g2it.programs;


public class FibonacciSeries {
	public static void main(String[] args) {
		int noOfIteration = Integer.parseInt(args[0]);
		
		int twoBack = 1, oneBack = 2, current;
		
		System.out.print(twoBack + "  " + oneBack);
		
		for(int index = 1; index < noOfIteration - 1; index++) {
			current = twoBack + oneBack;
			System.out.print("  " + current);
			
			twoBack = oneBack;
			oneBack = current;
		}
	}
}
