package com.src.java.polymorphism.runtime;

class Child extends Parent{
	// Overloading
	void abc(final float z) {
		System.out.println("Child: Overloading abc with float parameter...[" + z + "]");
	}
	
	@Override
	void abc(final int z) {
		super.abc(1);
		System.out.println("Child: Overriding abc with int parameter...[" + z + "]");
	}
	
	@Override
	void abc() {
		System.out.println("Child: Overriding abc without parameter...");
		super.abc();
	}
	
	void mnop() {
		System.out.println("Child: Calling mnop...");
	}
}

