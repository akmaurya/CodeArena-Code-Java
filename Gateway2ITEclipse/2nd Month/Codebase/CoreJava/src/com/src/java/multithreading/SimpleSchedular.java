package com.src.java.multithreading;

public class SimpleSchedular {
	private static void run() {
		System.out.println("Run get called...");
	}
	
	public static void main(String[] args) {
		while(true) {
			try {
				run();
				Thread.sleep(5000);
			} catch (InterruptedException e) {
				System.out.println("Thread get interrupted..");
			}
		}
	}
}
