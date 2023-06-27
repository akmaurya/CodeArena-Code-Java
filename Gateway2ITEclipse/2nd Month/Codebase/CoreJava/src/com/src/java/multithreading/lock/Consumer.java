package com.src.java.multithreading.lock;

public class Consumer extends Thread {
	Stock st;
	int qreq;

	Consumer(Stock st, int q) {
		this.st = st;
		qreq = q;
	}

	public void run() {
		st.getQuantityOnHand(qreq);
	}
}
