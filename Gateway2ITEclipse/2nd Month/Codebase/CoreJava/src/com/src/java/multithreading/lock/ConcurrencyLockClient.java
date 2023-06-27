package com.src.java.multithreading.lock;

public class ConcurrencyLockClient {
	public static void main(String[] args) {
		ConcurrencyLockExample ex = new ConcurrencyLockExample(new Resource());
		
		Thread one = new Thread(ex);
		Thread two = new Thread(ex);
		Thread three = new Thread(ex);
		
		one.start();
		two.start();
		three.start();
	}
}
