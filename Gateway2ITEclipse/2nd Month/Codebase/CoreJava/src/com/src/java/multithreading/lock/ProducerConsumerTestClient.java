package com.src.java.multithreading.lock;

public class ProducerConsumerTestClient {
	public static void main(String[] args) {
		Stock stock = new Stock();

		Producer p1 = new Producer(stock, 1);
		Producer p2 = new Producer(stock, 5);
		Producer p3 = new Producer(stock, 11);

		Consumer c1 = new Consumer(stock, 5);
		Consumer c2 = new Consumer(stock, 4);
		Consumer c3 = new Consumer(stock, 3);
		Consumer c4 = new Consumer(stock, 2);

		c1.start();
		p2.start();
		c2.start();
		p1.start();
		c3.start();
		c4.start();
		p3.start();
	}
}
