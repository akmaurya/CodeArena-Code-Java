package com.src.java.modifiers;

public class NotFinalExamples {	
	String varX = "test";
	int varY = 5;
	
	public static void main(String[] args) {
		NotFinalExamples notFinalExamples = new NotFinalExamples();
		
		System.out.println("Value of varX is - " + notFinalExamples.varX);
		System.out.println("Value of vary is - " + notFinalExamples.varY);		
		notFinalExamples.testMethod(notFinalExamples);
		System.out.println("Value of varX is - " + notFinalExamples.varX);
		System.out.println("Value of vary is - " + notFinalExamples.varY);
	}
	
	void testMethod(final NotFinalExamples notFinalExamples) {
		notFinalExamples.varX = "changed";
		notFinalExamples.varY = 10;
		System.out.println("Value of varX inside testMethod is - " + notFinalExamples.varX);
		System.out.println("Value of vary  inside testMethod is - " + notFinalExamples.varY);
		
		NotFinalExamples newNotFinalExamples = new NotFinalExamples();
		newNotFinalExamples.varX = "new Changed";
		newNotFinalExamples.varY = 15;
		
		//notFinalExamples = newNotFinalExamples;		
	}
}
