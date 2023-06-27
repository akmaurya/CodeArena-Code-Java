package com.src.java.multithreading;

import java.util.Date;

public class MyRunnable implements Runnable {

	@Override
	public synchronized void run() {
		Thread thread = Thread.currentThread();
		System.out.println("RunnableJob started by " + thread.getName() + " at " + new Date());
		try {
			Thread.sleep(500);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println("RunnableJob ended by " + thread.getName() + " at " + new Date());
	}
}
