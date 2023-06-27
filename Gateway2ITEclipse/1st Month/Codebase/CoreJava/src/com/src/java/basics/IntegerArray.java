package com.src.java.basics;

/**
 * Double dimentional Array example for Integer
 * @author GPS
 *
 */
public class IntegerArray {
	
	/**
	 * 
	 * @param args
	 */
	public static void main(String args[]) {
		// Instantiate double dimensional integer array
		int arr[][] = new int[5][];

		arr[0] = new int[2];
		arr[1] = new int[4];
		
		// arr = null; 

		// Initialize double dimensional integer array
		int array[][] = new int[][] { 
										{ 3, 5, 8, 9 }, 
										{ 6, 7 } 
									};

		for (int i = 0; i < array.length; i++) {
			for (int j = 0; j < array[i].length; j++) {
				//array[i][j] = 45;
				System.out.print(array[i][j] + "----");
			}
			System.out.println();
		}
		
		// Single dimensional
		int singleArray[] = new int[] {1,2,3,4,5,6};
		
		int index = 0;
		for(; index < singleArray.length; ) {
			System.out.println(singleArray[index]);
			index++;
		}		
	}
}
