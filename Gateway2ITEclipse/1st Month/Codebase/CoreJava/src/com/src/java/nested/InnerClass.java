package com.src.java.nested;

class BaseParent {
	int intX = 100;
}

class EnclosingClass extends BaseParent {
	int intX = 10;

	void displayIntX(final int intX) {
		super.intX = intX;
	}

	void displayIntX() {
		System.out.println("Enclosing class method displayIntX get called....");
		System.out.println("local intX:" + intX);
		System.out.println("super intX:" + super.intX);
		InnerClass innerObject = new InnerClass();
		System.out.println("nested intX:" + innerObject.intX);
		System.out.println("\n");
	}

	// Inner Class
	class InnerClass {
		int intX = 90;

		void displayIntX() {
			System.out.println("Inner class method displayIntX get called....");
			System.out.println("local i=" + intX);
			System.out.println("Enclosing intX=" + EnclosingClass.this.intX);
			System.out.println("Enclosing intX=" + EnclosingClass.super.intX);
			System.out.println("\n");
		}
	}
}

public class InnerClass {
	public static void main(String[] args) {
		EnclosingClass enclosingClassObject = new EnclosingClass();
		enclosingClassObject.displayIntX();
		
		EnclosingClass.InnerClass inner = enclosingClassObject.new InnerClass();
		inner.displayIntX();

		enclosingClassObject.displayIntX(100 + 2);
		enclosingClassObject.intX = enclosingClassObject.intX + 2;
		inner.intX = inner.intX + 2;
		enclosingClassObject.displayIntX();
		inner.displayIntX();
	}
}
