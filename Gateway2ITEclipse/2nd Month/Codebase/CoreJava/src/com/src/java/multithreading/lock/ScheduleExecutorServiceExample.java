package com.src.java.multithreading.lock;

import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class ScheduleExecutorServiceExample {
	private static final int NTHREDS = 3;

	public static void main(String[] args) throws InterruptedException {
		ScheduledExecutorService executor = new ScheduledThreadPoolExecutor(NTHREDS);
		for (int i = 0; i < 5; i++) {
			Runnable worker = new MyRunnable(1L + i);
			executor.scheduleAtFixedRate(worker, 2, 10, TimeUnit.SECONDS);
		}
	}
}
