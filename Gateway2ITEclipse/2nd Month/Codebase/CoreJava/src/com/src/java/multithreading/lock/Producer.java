package com.src.java.multithreading.lock;

public class Producer extends Thread {
	Stock st;
	int quantity;

	Producer(Stock st, int q) {
		this.st = st;
		quantity = q;
	}

	public void run() {
		st.setQuantityOnHand(quantity);
	}
}
