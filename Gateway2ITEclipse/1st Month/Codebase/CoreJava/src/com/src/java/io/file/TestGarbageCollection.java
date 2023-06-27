package com.src.java.io.file;

public class TestGarbageCollection {
	public static void main(String[] args) throws InterruptedException {

		Runtime rt = Runtime.getRuntime();

		System.out.println("Result for Non Finalized Class ---");
		System.out.println("Available Free Memory (Before Object creation): " + rt.freeMemory());

		NonFinalizedClass nonFinalizedClass[] = new NonFinalizedClass[100000];
		for (int i = 0; i < 100000; i++) {
			nonFinalizedClass[i] = new NonFinalizedClass("hello", 5);
		}

		System.out.println("Available Free Memory (After Object creation) : " + rt.freeMemory());
		System.runFinalization();
		System.gc();
		System.out.println("Available Free Memory (after gc() call)       : " + rt.freeMemory());

//		System.out.println("Result for Finalized Class ---");
//		System.out.println("Available Free Memory (Before Object creation): " + rt.freeMemory());
//
//		FinalizedClass finalizedClass[] = new FinalizedClass[5000];
//		for (int i = 0; i < 50000; i++) {
//			finalizedClass[i] = new FinalizedClass("hello", 5);
//		}
//
//		System.out.println("Available Free Memory (After Object creation) : " + rt.freeMemory());
//		System.runFinalization();
//		System.gc();
//		System.out.println("Available Free Memory (after gc() call)       : " + rt.freeMemory());
	}
}
