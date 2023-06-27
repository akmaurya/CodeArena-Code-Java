package com.src.java.multithreading.lock;

public class Philospher implements Runnable {
	private Fork leftFork, rightFork;

	Philospher(Fork a, Fork b) {
		this.leftFork = a;
		this.rightFork = b;
	}

	@Override
	public void run() {
		while (true) {

			// eating
			if (leftFork.isFree() && rightFork.isFree()) {
				leftFork.eating();
				rightFork.eating();
				try {
					Thread.sleep(2000);
				} catch (Exception exc) {
					System.out.println("Exception found...");
				}
			} else {
				// thinking
				leftFork.thinking();
				rightFork.thinking();
				try {
					Thread.sleep(3000);
				} catch (Exception exc) {
					System.out.println("Exception found...");
				}
			}
		}
	}

}
