package com.src.java.multithreading.lock;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class CallableFutures {
	private static final int NTHREDS = 10;

	public static void main(String[] args) {

		ExecutorService executor = Executors.newFixedThreadPool(NTHREDS);
		List<Future<Long>> list = new ArrayList<Future<Long>>();
		for (int i = 0; i < 200; i++) {
			Callable<Long> worker = new MyCallable();
			Future<Long> submit = executor.submit(worker);
			list.add(submit);
		}
		long sum = 0;
		System.out.println("Total threads: " + list.size());
		// now retrieve the result
		for (Future<Long> future : list) {
			try {
				sum += future.get();
			} catch (InterruptedException e) {
				e.printStackTrace();
			} catch (ExecutionException e) {
				e.printStackTrace();
			}
		}
		System.out.println("Sum total are: " + sum);
		executor.shutdown();
	}

}
