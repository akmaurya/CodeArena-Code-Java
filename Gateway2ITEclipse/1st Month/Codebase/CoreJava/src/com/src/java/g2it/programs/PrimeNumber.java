package com.src.java.g2it.programs;

public class PrimeNumber {
	public String isPrimeNumber(int inputVal) {
		int num = 2;
		
		for(; num < inputVal; num++) {
			if(inputVal % num == 0) {
				break;
			}
		}
		
		
		return (inputVal == num ? "YES" : "NO");
	}
	
	public static void main(String[] args) {
		System.out.println(new PrimeNumber().isPrimeNumber(7));
	}
}
