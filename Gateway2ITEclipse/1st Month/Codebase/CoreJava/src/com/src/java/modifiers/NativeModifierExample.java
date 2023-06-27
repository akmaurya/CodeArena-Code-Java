package com.src.java.modifiers;

//A simple example that uses a native method. 
public class NativeModifierExample {
	int i;
	public static void main(String args[]) {
		NativeModifierExample ob = new NativeModifierExample();
		ob.i = 10;

		System.out.println("This is ob.i before the native method:" + ob.i);
		ob.test(); // call a native method
		System.out.println("This is ob.i after the native method:" + ob.i);
	}

	// declare native method
	public native void test();

	// load DLL that contains static method
	static {
		System.loadLibrary("NativeDemo");
	}
}
