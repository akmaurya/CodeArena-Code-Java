package com.src.java.multithreading.lock;

public class Fork {
	private boolean free = true;

	synchronized void eating() {
		while (!free) {
			try {
				wait();
			} catch (Exception exc) {
				System.out.println("Exception found...");
			}
		}
		System.err.println("Thread - [" + Thread.currentThread().getName() + "] Eating...");
		free = false;
	}

	synchronized void thinking() {
		notifyAll();
		System.out.println("Thread - [" + Thread.currentThread().getName() + "] Thinking...");
		free = true;
	}

	public boolean isFree() {
		return free;
	}	
}
