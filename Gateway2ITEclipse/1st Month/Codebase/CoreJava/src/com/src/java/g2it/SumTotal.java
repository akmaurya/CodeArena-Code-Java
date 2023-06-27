package com.src.java.g2it.programs;

public class SumTotal {
	public int getSumTotal(int intputVal) {
		int sum = 0;
		
		while(intputVal > 1) {
			sum = sum + intputVal%10;
			intputVal = intputVal / 10;
		}
		return sum;
	}
	
	public static void main(String[] args) {
		System.out.println(new SumTotal().getSumTotal(44545));
	}
}
