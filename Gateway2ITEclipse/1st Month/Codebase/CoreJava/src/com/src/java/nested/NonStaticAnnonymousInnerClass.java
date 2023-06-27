package com.src.java.nested;

interface MyInterface {
	int intVarX = 5;
	void display();
}

class TestClass {
	int intVarX = 5;
	void display() {}
}

class AnonymousEnclosingClass {
	int intvarX = 15;

	@SuppressWarnings("unused")
	void innerMethod() {
		int intvarX = 20;

		// Anonymous Class...
		MyInterface myInterface = new MyInterface() {
			@SuppressWarnings("static-access")
			public void display() {
				int intvarX = 25;
				System.out.println("local intvarX: " + intvarX);
				System.out.println("this MyInterface intvarX: " + this.intVarX);
				System.out.println("this intvarX: " + AnonymousEnclosingClass.this.intvarX);
				System.out.println("MyInterface intvarX: " + MyInterface.intVarX);
				// System.out.println("MyInterface intvarX: " + intVarZ);
				mnop(); // call other method
				System.out.println("\n");
			}
			
			// int intvarZ = 90;

			public void mnop() {
				System.out.println("Inside MNOP...");
			}
		};

		myInterface.display();
		//myInterface.mnop(); // Can't call

		// Anonymous Class...
		TestClass testObject = new TestClass() {
			public void display() {
				int intVarX = 25;
				System.out.println("local i: " + intVarX);
				System.out.println("this CLASS i: " + this.intVarX);
				System.out.println("this i: " + AnonymousEnclosingClass.this.intvarX);
				mnop();
				// System.out.println("MyInterface intVarX: " + TestClass.intVarX);
			}

			public void mnop() {
				System.out.println("Inside MNOP...");
			}
		};

		testObject.display();
		// testObject.mnop(); // Can't call
	}

}

public class NonStaticAnnonymousInnerClass {
	public static void main(String[] args) {
		AnonymousEnclosingClass anonymous = new AnonymousEnclosingClass();
		anonymous.innerMethod();
	}
}
