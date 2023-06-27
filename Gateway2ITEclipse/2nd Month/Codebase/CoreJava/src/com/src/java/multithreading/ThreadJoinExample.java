package com.src.java.multithreading;

public class ThreadJoinExample implements Runnable {

	public void run() {

		Thread t = Thread.currentThread();
		System.out.print(t.getName());
		// checks if this thread is alive
		System.out.println(", status = " + t.isAlive());
	}

	public static void main(String args[]) throws Exception {

		Thread t = new Thread(new ThreadJoinExample());

		// this will call run() function
		t.start();

		// waits for this thread to die
		t.join();
		System.out.print(Thread.currentThread().getName());

		// checks if this thread is alive
		System.out.println(", status = " + Thread.currentThread().isAlive());

		// checks if this thread is alive
		System.out.println(t.getName() + ", status = " + t.isAlive());
	}
}
