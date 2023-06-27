package com.src.java.string;

public class StringBuilderDemo {
	public static void main(String[] args) {
		String palindrome = "Dot saw I was Tod";

		StringBuilder sb = new StringBuilder(palindrome);
		sb.reverse(); // reverse it
		// sb.toString() is called implicitly
		System.out.println(sb);
		
		StringBuilder str = new StringBuilder("tutorials ");
	    System.out.println("string = " + str);
	    
	    // appends the string argument to the StringBuilder
	    str.append("point");
	    // print the StringBuilder after appending
	    System.out.println("After append = " + str);
	    
	    str = new StringBuilder("1234 ");
	    System.out.println("string = " + str);
	    // appends the string argument to the StringBuilder 
	    str.append("!#$%");
	    // print the StringBuilder after appending
	    System.out.println("After append = " + str);
	}
}
