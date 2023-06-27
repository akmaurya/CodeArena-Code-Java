package com.src.java.basics;

public class ConditionalStatements {

	@SuppressWarnings("unused")
	public static void main(String[] args) {
		final int VARX = 5;
		final int VARY = 10;
		final int VARZ = 15;

		if (VARX > VARY && VARX > VARZ) {
			System.out.println("varX is biggest");
		} else if (VARY > VARX && VARY > VARZ) {
			System.out.println("varY is biggest");
		} else {
			System.out.println("varZ is biggest");
		}

		// Conditional (?:)
		System.out.println(VARX > VARY && VARX > VARZ ? "varX" : (VARY > VARX && VARY > VARZ ? "varY" : "varZ")
				+ " is biggest");

		System.out.println("Test switch case, break play very important role - ");
		switch (VARX) {
		case 1:
			System.out.println("1");
		case 2:
			System.out.println("2");
			break;
		case 5:
			System.out.println("5");
		case 6:
			System.out.println("6");
		case 7:
			System.out.println("7");
			break;
		case 8:
			System.out.println("8");
		default:
			System.out.println("default");
		}
	}
}
