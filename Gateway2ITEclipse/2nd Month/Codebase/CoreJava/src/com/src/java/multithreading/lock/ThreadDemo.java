package com.src.java.multithreading.lock;

public class ThreadDemo extends Thread {
	private String threadName;
	private PrintDemo printDemo;

	ThreadDemo(String name, PrintDemo pd) {
		threadName = name;
		printDemo = pd;
	}

	@Override
	public void run() {
		printDemo.printCount(threadName);
		System.out.println("Thread " + threadName + " exiting.");
	}
}
