package com.src.java.polymorphism.runtime;

public class TestRuntimePolymorphism {
	public static void main(String arg[]) {
		Parent parent = new Parent();
		parent.abc();
		parent.abc(5);
		
		parent = new Child(); // upcasting
		parent.abc();
		parent.abc(10);
		
		//parent.mnop();
		((Child) parent).mnop(); // Down casting
		
		// parent.abc(10.5f);
		((Child) parent).abc(10.5f);
	}
}
