package com.src.java.string;

import java.util.StringTokenizer;

public class StringToKenizer {
	private static final String str = "Application Apple Applaude Cat Rat";

	public static void main(String[] args) {
		// Use of Split method with regex
		String arr[] = str.split("App*");
		System.out.println("Output of Split - ");
		for (int i = 0; i < arr.length; i++) {
			System.out.println(arr[i]);
		}

		// Use of StringTokenizer
		StringTokenizer stk = new StringTokenizer(str, " ");
		System.out.println("\n\nOutput of StringTokenizer - ");
		while (stk.hasMoreTokens()) {
			System.out.println(stk.nextToken());
		}

		// Use of StringTokenizer with regex
		stk = new StringTokenizer(str, "App*");
		System.out.println("\n\nOutput of StringTokenizer - ");
		while (stk.hasMoreTokens()) {
			System.out.println(stk.nextToken());
		}
	}
}
