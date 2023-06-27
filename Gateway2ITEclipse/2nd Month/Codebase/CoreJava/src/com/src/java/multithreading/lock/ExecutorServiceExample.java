package com.src.java.multithreading.lock;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class ExecutorServiceExample {
	private static final int NTHREDS = 500;

	public static void main(String[] args) throws InterruptedException {
		ExecutorService executor = Executors.newFixedThreadPool(NTHREDS);
		for (int i = 0; i < 50000; i++) {
			Runnable worker = new MyRunnable(10000000L + i);
//			Thread th = new Thread(worker);
//			th.start();
			executor.execute(worker);
		}
		// This will make the executor accept no new threads
		// and finish all existing threads in the queue
		executor.shutdown();
		// Wait until all threads are finish
		executor.awaitTermination(1000L, TimeUnit.SECONDS);
		System.out.println("Finished all threads");
	}

}
