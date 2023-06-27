package com.src.java.multithreading;

public class TestThread {
	public static void main(String[] args) {
		DisplayThread disp1 = new DisplayThread("Th1");
		DisplayThread disp2 = new DisplayThread("Th2");
		
		disp1.start();
		disp2.start();
	}
}
