package com.src.java.multithreading;

public class DisplayBanner implements Runnable {
	String marqueeText = "Welcome to Hello World";

	@Override
	public void run() {
		System.out.println(Thread.currentThread().getName());
		while (true) {
			char ch = marqueeText.charAt(0);
			String s = marqueeText.substring(1, marqueeText.length());
			s += ch;
			System.out.println(s);
			marqueeText = s;
			try {
				System.out.println(Thread.currentThread().getName());
				Thread.sleep(1000);
			} catch (InterruptedException ie) {
			}
		}
	}

}
