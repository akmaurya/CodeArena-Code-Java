package com.src.java.modifiers;

/**
 * Subclass can't override any method of final class
 * 
 * @author GPS
 * 
 */
public class FinalModifierExample {
	final private String varX = "test";

	final private String varY;
	final private String varZ;

	{
		varY = "initilization block";
	}

	// Default constructor
	FinalModifierExample() {
		varZ = "constructor";
	}

	public static void main(String[] args) {
		new FinalModifierExample().printVariablesValues();
	}

	// final method which can't be intialize
	final void printVariablesValues() {
		// Can't assign value inside final variable
//		 varY = "initilization block";
//		 varZ = "constructor";
		System.out.println(varX + "---" + varY + "---" + varZ);
	}

	void otherMethod() {
		System.out.println("Called otherMethod inside FinalModifierExample");
	}
}
