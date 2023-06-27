package com.src.java.basics;

public class TestStaticOverriden extends ExecutionSteps {
//	@Override
//	static void staticMethod() {
//		System.out.println("Static Method can't be override...");
//	}

	// Default constructor
	TestStaticOverriden() {
		System.out.println("Constructor called from Child...");
	}

	// Initialization block called just before constructor
	{
		System.out.println("Initialization block called from child...");
	}

	// Called during class loading by class loader...
	static {
		System.out.println("Static Initialization block called from child...");
	}

	@Override
	void instanceMethod() {
		System.out.println("Overriding Instance Method from Child...");
	}

	public static void main(String[] args) {
		System.out.println("Main called from TestStaticOverriden...");
		new TestStaticOverriden().instanceMethod();
	}
}
