package com.src.java.immutable;

public class TestClient2 extends ImmutableClass {

	TestClient2(int x, int y) {
		super(x, y);
	}
	
//	@Override
//	public final int getX() {
//		return 30;
//	}
//
//	@Override
//	public final int getY() {
//		return 40;
//	}
	
	public static void main(String[] args) {
		TestClient2 testClient2 = new TestClient2(10, 20);
		
		System.out.println("Value of varX is - " + testClient2.getX());
		System.out.println("Value of vary is - " + testClient2.getY());		
	}	
}
