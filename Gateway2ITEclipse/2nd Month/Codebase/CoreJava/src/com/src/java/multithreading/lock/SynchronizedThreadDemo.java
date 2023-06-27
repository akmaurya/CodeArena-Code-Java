package com.src.java.multithreading.lock;

public class SynchronizedThreadDemo extends Thread {
	private String threadName;
	private PrintDemo printDemo;

	SynchronizedThreadDemo(String name, PrintDemo pd) {
		threadName = name;
		printDemo = pd;
	}

	@Override
	public void run() {
		synchronized (printDemo) {
			printDemo.printCount(threadName);
			System.out.println("Thread " + threadName + " exiting.");
		}			
	}
}
