package com.src.java.basics;

public class ScopeVariables {
	int i = 70; // instance variable or Member variables

	public static void main(String a[]) {
		ScopeVariables scopeVariables = new ScopeVariables();
		scopeVariables.printValues();
	}
	
	private void printValues() {
		int i = 10; // local variable
		System.out.println("Local value : " + i);
		System.out.println("Instance value : " + this.i);
	}
}
