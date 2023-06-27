package com.src.java.students;

public class DaemonThread {

	public DaemonThread() {
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args) {
		System.out.println("Start " + Thread.currentThread());
		// Thread.currentThread().setDaemon(true);
		System.out.println("End " + Thread.currentThread());
	}
}
