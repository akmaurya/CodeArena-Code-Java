package com.src.java.operators;

class A {
	///
}

class B extends A {
	
}

class C extends B {
	
}

public class InstanceOfOperator {
	
	@SuppressWarnings("unused")
	public static void main(String aaa[]) {
		A a = new A();
		B b = new B();
		C c = new C();
		
		if(b instanceof C) {
			System.out.println("B is instance of A");
		} else {
			System.out.println("B is not instance of C");
		}
		
		if(c instanceof A || c instanceof B) {
			System.out.println("C is instance of A OR B");
		} else {
			System.out.println("C is not instance of A OR B");
		}
		
		if(b instanceof A && b instanceof C) {
			System.out.println("B is instance of A && C");
		} else {
			System.out.println("B is not instance of A && c");
		}
	}
}
