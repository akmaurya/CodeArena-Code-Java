package com.src.java.nested;

public class StaticNestedOuterClass {
	int instanceVarInt = 10;
	char instanceChar = 'a';
	static int staticIntX = 20;

	void set() {
		// instanceVarInt, instanceChar are accessible
		StaticNestedOuterClass.NestedClass nestedObject = new StaticNestedOuterClass.NestedClass();
		// StaticNestedOuterClass.class compiled file Enclosing / outer class
		// StaticNestedOuterClass$nestedClass1.class compiled file for Nested class
		nestedObject.display();
	}

	public static void main(String[] args) {
		new StaticNestedOuterClass().set();
	}

	private static class NestedClass {
		int localIntX = 90;

		void display() {
			// can't use instanceVarInt and instanceChar here coz these are instance variable
			System.out.println("staticIntX=" + staticIntX);
			System.out.println("Nested localIntX=" + localIntX);
			
			// if we want to use instanceVarInt and instanceChar then
			StaticNestedOuterClass test = new StaticNestedOuterClass();
			System.out.println("instanceVarInt=" + test.instanceVarInt);
			System.out.println("instanceChar=" + test.instanceChar);
		}
	}
}
