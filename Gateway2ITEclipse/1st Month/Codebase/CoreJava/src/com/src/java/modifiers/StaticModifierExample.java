package com.src.java.modifiers;

import com.src.java.utility.StringUtils;


public class StaticModifierExample {
	private String str = "hello";
	
	private static int shareData;
	private int instanceVariable;
	
	public static void main(String[] args) {
		StaticModifierExample objectInstance = new StaticModifierExample();
		System.out.println("Can't use non-static varibale directly, use with only object instance - " + objectInstance.str);
		objectInstance.compareShareDataAndInstanceVariable();
		
		// Utility class example...
		System.out.println("String is - " + StringUtils.isStringEmpty(null));
		System.out.println("String is - " + StringUtils.isStringEmpty("hello"));
	}
	
	@SuppressWarnings("static-access")
	private void compareShareDataAndInstanceVariable() {
		System.out.println("Intial value of shareData - " + shareData);
		System.out.println("Intial value of instanceVariable - " + instanceVariable);
		StaticModifierExample object1 = new StaticModifierExample();
		object1.shareData = 1;
		object1.instanceVariable = 1;
		
		StaticModifierExample object2 = new StaticModifierExample();
		object2.shareData = 2;
		object2.instanceVariable = 2;
		
		System.out.println("Value of object1.shareData - " + object1.shareData);
		System.out.println("Value of object1.instanceVariable - " + object1.instanceVariable);
		
		System.out.println("Value of object2.shareData - " + object2.shareData);
		System.out.println("Value of object2.instanceVariable - " + object2.instanceVariable);
	}
}
