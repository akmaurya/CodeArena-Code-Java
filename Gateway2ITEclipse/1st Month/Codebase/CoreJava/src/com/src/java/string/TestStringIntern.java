package com.src.java.string;

public class TestStringIntern extends Object {
	public static void main(String[] args) {
		
		// Scenario - 1
		String str1 = "hello"; // Allocate space in pool
		String str2 = new String("hello"); // Allocate object into heap
		
		if(str1 == str2) {
			System.out.println("str1 & str2 are pointing same reference");
		} else {
			System.out.println("str1 & str2 are not pointing same reference");
		}
		
		if(str1.equals(str2)) {
			System.out.println("str1 & str2 are equals");
		} else {
			System.out.println("str1 & str2 are not equals");
		}
		
		if(str1 == str2.intern()) {
			System.out.println("str1 & str2 are pointing same reference");
		} else {
			System.out.println("str1 & str2 are not pointing same reference");
		}
		
		//Scenario - 2
		String str3 = new String("Java"); // Allocate object into heap
		String str4 = new String("Java"); // Allocate object into heap
		
		if(str3 == str4) {
			System.out.println("str3 & str4 are pointing same reference");
		} else {
			System.out.println("str3 & str4 are not pointing same reference");
		}
		
		if(str3.intern() == str4) {
			System.out.println("str3 & str4 are pointing same reference");
		} else {
			System.out.println("str3 & str4 are not pointing same reference");
		}
		
		if(str3 == str4.intern()) {
			System.out.println("str3 & str4 are pointing same reference");
		} else {
			System.out.println("str3 & str4 are not pointing same reference");
		}
		
		if(str3.intern() == str4.intern()) {
			System.out.println("str3 & str4 are pointing same reference");
		} else {
			System.out.println("str3 & str4 are not pointing same reference");
		}
	}
}
