package com.src.java.immutable;


public class TestClient1 {
	public static void main(String[] args) {
		ImmutableClass immutableClassRef = new ImmutableClass(10, 20);
		
		System.out.println("Value of varX is - " + immutableClassRef.getX());
		System.out.println("Value of vary is - " + immutableClassRef.getY());		
	}	
}
