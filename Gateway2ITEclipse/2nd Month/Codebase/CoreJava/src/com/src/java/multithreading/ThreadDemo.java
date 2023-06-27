package com.src.java.multithreading;

public class ThreadDemo extends Thread {
	private Thread t;
	private String threadName;
	PrintDemo printDemo;

	ThreadDemo(String name, PrintDemo pd) {
		threadName = name;
		printDemo = pd;
	}

	public void run() {
		printDemo.printCount();
		System.out.println("Thread " + threadName + " exiting.");
	}

	public void start() {
		System.out.println("Starting " + threadName);
		if (t == null) {
			t = new Thread(this, threadName);
			t.start();
		}
	}
}
