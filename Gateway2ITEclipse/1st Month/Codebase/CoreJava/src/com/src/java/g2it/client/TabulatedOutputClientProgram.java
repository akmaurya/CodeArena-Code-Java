package com.src.java.g2it.programs.client;

import java.util.Scanner;

import com.src.java.g2it.programs.Palimdrome;
import com.src.java.g2it.programs.PrimeNumber;
import com.src.java.g2it.programs.SumTotal;


public class TabulatedOutputClientProgram {
	public static void main(String[] args) {

		//int userInputArr[] = new int[] {121, 123, 1234, 27, 5, 737832};
		int userInputArr[] = new int[5];

		Scanner in = new Scanner(System.in);
		for (int i = 0; i < 5; i++) {
			System.out.println("Enter value for position [" + i + "]-");
			userInputArr[i] = in.nextInt();
		}
		
		System.out.println("----------------------------------------------------");
		System.out.println("|User Input Parameter|Sum total of parameter|Is Prime?");
		System.out.println("----------------------------------------------------");

		SumTotal sumTotal = new SumTotal();
		PrimeNumber primeNumber = new PrimeNumber();
		Palimdrome palimdrome = new Palimdrome();
		for (int i = 0; i < userInputArr.length; i++) {
			System.out.print("|     " + userInputArr[i]);
			System.out.print("|     " + sumTotal.getSumTotal(userInputArr[i]) + "    |");
			System.out.print("|     " + primeNumber.isPrimeNumber(userInputArr[i]) + "    |");
			System.out.print("|     " + palimdrome.isPalindrome(userInputArr[i]) + "    |");
			System.out.println();
		}
	}
}
