package com.src.java.multithreading;

public class DisplayThread extends Thread {
	String msg;

	DisplayThread(String m) {
		msg = m;
	}

	@Override
	public void run() {
		for (int i = 0; i < 10; i++) {
			System.out.println(Thread.currentThread().getName() + " : " + i);
		}
	}
}
