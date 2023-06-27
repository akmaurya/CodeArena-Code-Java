package com.src.java.multithreading;

public class TestBanner {
	public static void main(String[] args) {
		DisplayBanner disp = new DisplayBanner();
		
		Thread th = new Thread(disp);
		Thread th1 = new Thread(disp);
		Thread th2 = new Thread(disp);
		th.start();
		th1.start();
		th2.start();
		
//		th.run();
		System.out.println("................................................Main end...");
	}
}
