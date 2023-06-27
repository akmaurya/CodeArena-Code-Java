package com.src.java.multithreading.lock;

public class Stock {
	private int quantityOnHand;

	// for Consumer
	synchronized void getQuantityOnHand(int Qreq) {
		if (quantityOnHand < Qreq) {
			try {
				System.out.println(Thread.currentThread().getName() + ": Consumer needs [" + Qreq + "] & Stock is [" + quantityOnHand + "], So it is waiting...");
				this.wait();
			} catch (InterruptedException e) {
				System.out.println("Consumer InterruptedException");
			}
		} else {
			System.out.println("Consumer consume..." + quantityOnHand + " > " + Qreq);
			quantityOnHand = quantityOnHand - Qreq;
		}
	}

	// for Producer
	synchronized void setQuantityOnHand(int quantityOnHand) {
		this.quantityOnHand += quantityOnHand;
		System.out.println(Thread.currentThread().getName() + ": Producer produces [" + quantityOnHand + "] Stock is [" + this.quantityOnHand + "] and notify all waiting consumers....");
		this.notifyAll();
	}
}
