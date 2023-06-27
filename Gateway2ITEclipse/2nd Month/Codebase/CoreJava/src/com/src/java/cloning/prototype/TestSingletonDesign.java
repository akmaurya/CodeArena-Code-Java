package com.src.java.cloning.prototype;

public class TestSingletonDesign {
	@SuppressWarnings("unused")
	public static void main(String[] args) {
		PrototypeFactory prototypeFactory = PrototypeFactory.getInstance();
		
		prototypeFactory = PrototypeFactory.getInstance();
		
		prototypeFactory = PrototypeFactory.getInstance();
		
	}
}
