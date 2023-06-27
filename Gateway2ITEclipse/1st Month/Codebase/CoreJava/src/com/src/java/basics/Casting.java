package com.src.java.basics;

public class Casting {
	public static void main(String args[]) {
		int intVal = 66;
		char charVal = 65;

		// explicit cast – down casting
		char charCastVal = (char) intVal; 
		
		// Printing character value of ascii
		System.out.println("value of charVal: " + charVal + "  --- charCastVal : " + charCastVal);
		
		// implicit casting --- up casting
		int intCastVal = charVal; 
		System.out.println("value of intCastVal: " + intCastVal);
		
		byte byteValue = 121;
		byte negativeByteValue = -128;
		
		// Compilation error - if value out of range (+127 to -128)
		byte byteValueExplicitCast = (byte) 129;
		
		// Compilation error - if value out of range (+127 to -128)
		byte negativeByteValueExplicitCast = (byte) -129;
				
		System.out.println("value of byteValue: " + byteValue);
		System.out.println("value of negativeByteValue: " + negativeByteValue);
		System.out.println("value of byteValueExplicitCast: " + byteValueExplicitCast);
		System.out.println("value of negativeByteValueExplicitCast: " + negativeByteValueExplicitCast);
	}

}
