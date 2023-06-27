package com.src.java.java5;

public class VarArgsExample {
	int sumArrays(int[]... intArrays) {
		int sum, i, j;

		sum = 0;
		for (i = 0; i < intArrays.length; i++) {
			for (j = 0; j < intArrays[i].length; j++) {
				sum += intArrays[i][j];
			}
		}

		return (sum);
	}

	public static void main(String args[]) {
		VarArgsExample va = new VarArgsExample();
		int sum = 0;

		sum = va.sumArrays(new int[] { 1, 2, 3 }, 
				new int[] { 4, 5, 6 }, 
				new int[] { 100, 200 });
		System.out.println("The sum of the numbers is: " + sum);
	}
}
