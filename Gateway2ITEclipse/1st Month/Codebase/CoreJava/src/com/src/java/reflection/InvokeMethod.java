package com.src.java.reflection;

import java.lang.reflect.Method;

public class InvokeMethod {
	public static void main(String[] args) throws ClassNotFoundException, InstantiationException,
			IllegalAccessException {
		// Get Class object for com.src.java.reflection.Foo
		Class<?> fooClass = Class.forName("com.src.java.reflection.Foo");

		// Create a new Instance of com.src.java.reflection.Foo
		Foo instance = (Foo) fooClass.newInstance();

		Method method;
		try {
			method = instance.getClass().getMethod("print", new Class<?>[0]);
			method.invoke(instance);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}

class Foo {
	public void print() {
		System.out.println("Method invoked via reflection...");
	}
}
