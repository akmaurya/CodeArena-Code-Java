package com.src.java.multithreading;

import java.util.Date;

public class YieldExample {
	public static void main(String[] args) throws InterruptedException {
		System.out.println("Main Thread started by " + Thread.currentThread().getName() + " at " + new Date());
		MyRunnable runnableJob = new MyRunnable();

		Thread thread1 = new Thread(runnableJob, "T1");
		thread1.setPriority(5);
		Thread thread2 = new Thread(runnableJob, "T2");
		thread1.setPriority(5);
		Thread thread3 = new Thread(runnableJob, "T3");
		thread1.setPriority(5);
		Thread thread4 = new Thread(runnableJob, "T4");
		thread1.setPriority(5);

		Thread.yield();
		thread1.start();
		Thread.yield();
		thread2.start();
		Thread.yield();
		thread3.start();
		Thread.yield();
		thread4.start();
		Thread.yield();
		System.out.println("Main Thread ended by " + Thread.currentThread().getName() + " at " + new Date());
	}
}
