package com.src.java.g2it.programs;

public class Palimdrome {
	public String isPalindrome(int inputVal) {
		
		int reverseVal = 0, originalValue = inputVal;
		int noOfdigit = getNoOfDigit(inputVal);
		
		while(inputVal >= 1) {
			int reminder = inputVal % 10;
			inputVal = inputVal / 10;
			
			reverseVal = reverseVal + (reminder * calculatePowerOfTen(noOfdigit));
			noOfdigit--;
		}
		return (originalValue == reverseVal ? "Yes" : "No");
	}

	public static void main(String[] args) {
		System.out.println(new Palimdrome().isPalindrome(12121));
	}
	
	private int calculatePowerOfTen(int power) {
		int powerTenVal = 1;
		for(int i=1; i<power; i++) {
			powerTenVal = powerTenVal * 10;
		}
		return powerTenVal;
	}

	/**
	 * This method find the no of digit of any input value
	 * 
	 * @param inputVal
	 * @return
	 */
	private int getNoOfDigit(int inputVal) {
		int count = 0;
		while (inputVal >= 1) {
			inputVal = inputVal / 10;
			count++;
		}
		return count;
	}
}
