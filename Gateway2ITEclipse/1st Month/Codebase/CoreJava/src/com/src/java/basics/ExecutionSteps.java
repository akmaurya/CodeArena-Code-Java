package com.src.java.basics;

/**
 * Steps of execution of blocks & methods...
 * 
 * @author GPS
 * 
 */
public class ExecutionSteps {

	// Default constructor
	ExecutionSteps() {
		System.out.println("3. Constructor called...");
	}

	// Initialization block called just before constructor
	{
		System.out.println("2. Initialization block called...");
	}

	// Called during class loading by class loader...
	static {
		System.out.println("1. Static Initialization block called...");
	}

	void instanceMethod() {
		System.out.println("Instance Method called...");
	}

	static void staticMethod() {
		System.out.println("Static Method called...");
	}
	
	static void staticMethod(final int varX) {
		System.out.println("Static Method can be overloaded called..." + varX);
	}

	@SuppressWarnings("unused")
	public static void main(String[] args) {
		System.out.println("Main method execution start...");
		ExecutionSteps executionSteps = new ExecutionSteps();
		ExecutionSteps executionSteps1 = new ExecutionSteps();
		staticMethod();
		staticMethod(5);
		executionSteps.instanceMethod();
		System.out.println("Main method execution end...");
	}
}
