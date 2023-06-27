package com.src.java.modifiers;

/**
 * Can't extend final class
 * @author GPS
 *
 */
public class TestFinalExample extends FinalModifierExample {
	
//	@Override
//	final void printVariablesValues() {
//		// can't overide final method
//	}
	public static void main(String[] args) {
		System.out.println("Main class from TestFinalExample...");
		// Only we can create reference of final class
		FinalModifierExample finalModifierExample = new FinalModifierExample();
		finalModifierExample.printVariablesValues();
		finalModifierExample.otherMethod();
	}
	
//	@Override
	void otherMethod() {
		System.out.println("Called otherMethod inside FinalModifierExample");
	}
}
