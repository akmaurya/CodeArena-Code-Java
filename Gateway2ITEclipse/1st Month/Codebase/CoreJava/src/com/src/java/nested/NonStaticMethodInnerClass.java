package com.src.java.nested;

class OuterClass {
	int intX = 10;

	// Inner class defined inside a Method body
	void display() {
		final int intA = 20;

		// Scope is only available till this method until and unless object not
		// returned
		class OuterInnerClass {
			int intX = 90;

			void display() {
				// we can't access any variables or methods except final type
				int intX = 70;
				System.out.println("intA=" + intA);
				System.out.println("local intX=" + intX);
				System.out.println("this intX=" + this.intX);
				System.out.println("final intX=" + OuterClass.this.intX);
				System.out.println("\n");
			}
		}

		OuterInnerClass in = new OuterInnerClass();
		in.display();
	}
}

public class NonStaticMethodInnerClass {
	public static void main(String[] args) {
		OuterClass out = new OuterClass();
		out.display();
	}
}
