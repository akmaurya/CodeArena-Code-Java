package com.src.java.multithreading.lock;

public class SyncrinizedThreadExample {
	public static void main(String args[]) {

		PrintDemo printDemo = new PrintDemo();

		// Non synchronized threads
//		ThreadDemo th1 = new ThreadDemo("Thread - 1 ", printDemo);
//		ThreadDemo th2 = new ThreadDemo("Thread - 2 ", printDemo);
//
//		th1.start();
//		th2.start();

		// Non synchronized threads
		SynchronizedThreadDemo sth1 = new SynchronizedThreadDemo("Thread - 1 ", printDemo);
		SynchronizedThreadDemo sth2 = new SynchronizedThreadDemo("Thread - 2 ", printDemo);

		sth1.start();
		sth2.start();

	}
}
