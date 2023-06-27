package com.src.java.multithreading.lock;

public class Dining {
	public static void main(String[] argv) {
		int size = 5;
		Fork[] forks = new Fork[size];
		for (int i = 0; i < size; ++i) {
			forks[i] = new Fork();
		}
		for (int i = 0; i < size; ++i) {
			// System.out.println(i + "-------" + ((i + 1) % size));
			Fork leftFork = forks[i];
			Fork rightFork = forks[(i + 1) % size];
			Philospher philospher;
			if (i % 2 == 0) {
				philospher = new Philospher(leftFork, rightFork);
			} else {
				philospher = new Philospher(rightFork, leftFork);
			}
			new Thread(philospher, "Philospher"+(i+1)).start();
		}
	}
}
