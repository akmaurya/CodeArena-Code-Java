package com.src.java.multithreading.lock;

public class Resource {
	public void doSomething() {
		System.out.println("1. doSomething..." + Thread.currentThread().getName());
		System.out.println("2. doSomething..." + Thread.currentThread().getName());
		System.out.println("3. doSomething..." + Thread.currentThread().getName());
	}

	public void doLogging() {
		System.out.println("1. doLogging..." + Thread.currentThread().getName());
		System.out.println("2. doLogging..." + Thread.currentThread().getName());
		System.out.println("3. doLogging..." + Thread.currentThread().getName());
	}
}
