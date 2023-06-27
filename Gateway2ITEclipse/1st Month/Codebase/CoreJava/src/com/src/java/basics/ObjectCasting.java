package com.src.java.basics;

class A {
	int i = 10;
}

class B extends A {
	int j = 20;
}

class C extends B {
	int k = 30;
}

class D extends C {
	int m = 40;
}

public class ObjectCasting {

	public static void main(String[] args) {
		new ObjectCasting().autoUpCasting();
	}

	@SuppressWarnings("unused")
	private void autoUpCasting() {
		D d = new D();
		C c = d; // D type object is Auto-Up Casted to C type
		B b = d; // D type object is Auto-Up Casted to B type
		C c1 = new C();
		A a = c1; // C type object is Auto-Up Casted to A type
		A a1 = new B(); // B type object is Auto-Up Casted to A type
	}

	@SuppressWarnings("unused")
	private void explicitDownCasting() {
		A a = new A();
		B b = (B) a; // A type is explicitly downcasted to B type
		C c = (C) a; // A type is explicitly downcasted to C type
		D d = (D) a; // A type is explicitly downcasted to D type
		B b1 = new B();
		D d1 = (D) b1; // B type is explicitly downcasted to D type
		d1 = (D) new C(); // C type is explicitly downcasted to D type
	}
}
