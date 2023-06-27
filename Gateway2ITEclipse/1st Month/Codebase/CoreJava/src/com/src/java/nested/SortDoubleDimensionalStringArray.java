package com.src.java.nested;

import java.util.Arrays;
import java.util.Comparator;

public class SortDoubleDimensionalStringArray {
	
	private static String packageVersionArrayStr [][] = {
															{"java6","6.00"},
															{"java5", "5.00"},
															{"java7", "7.00"}
														};
	public static void main(String[] args) {
		// Anonymous Class 
		Arrays.sort(packageVersionArrayStr, new Comparator<String[]>() {
			@Override
			public int compare(final String[] entry1, final String[] entry2) {
				final String version1 = entry1[0];
				final String version2 = entry2[0];

				return version1.compareTo(version2);
			}
		});
		
		System.out.println("Sorted Values are - ");
		for(int rowIndex=0; rowIndex < packageVersionArrayStr.length; rowIndex++) {
			System.out.println(packageVersionArrayStr[rowIndex][0] + "------" + packageVersionArrayStr[rowIndex][1]);
		}
	}
}
