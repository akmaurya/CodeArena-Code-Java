package com.src.java.multithreading.lock;

public class PrintDemo {
	public void printCount(final String threadName) {
		try {
			for (int i = 5; i > 0; i--) {
				System.out.println(threadName + " --- Counter   ---   " + i);
			}
		} catch (Exception e) {
			System.out.println("Thread  interrupted.");
		}
	}
}
