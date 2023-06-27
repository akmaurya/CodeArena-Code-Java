package com.src.java.basics;

public class ControlStatements {
	public static void main(String[] args) {

		System.out.println("Use of continue -----");
		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 3; j++) {
				if (i == j) {
					continue;
				}
				System.out.print(j + "    ");
			}
			System.out.println();
		}

		System.out.println("Use of break -----");
		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 3; j++) {
				if (i == j) {
					break;
				}
				System.out.print(j + "    ");
			}
			System.out.println();
		}

		System.out.println("\nUse of do while loop...which will excecute at least once...");
		int varX = 5;
		System.out.print("Value of X is - ");
		do {
			System.out.print(" " + varX++);
		} while (varX < 3);

		System.out
				.println("\n\nTo print all Odd no between 1 to 100 without using modulas(%) & division(/) in a single line of code...");
		for (int x = 1; x < 100; System.out.print("  " + x), x += 2);
	}
}
