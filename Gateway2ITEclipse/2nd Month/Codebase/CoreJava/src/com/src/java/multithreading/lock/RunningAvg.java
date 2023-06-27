package com.src.java.multithreading.lock;

import java.io.DataInputStream;
import java.io.PipedInputStream;

public class RunningAvg extends Thread {
	DataInputStream dis;

	RunningAvg(PipedInputStream pis) {
		dis = new DataInputStream(pis);
	}

	public void run() {
		try {
			double total = 0;
			int count = 0;
			while (true) {
				double d = dis.readDouble();
				total += d;
				count++;
				System.out.println("Avg no is :" + (total / count));
				sleep(1000);
			}
		} catch (Exception e) {
			System.out.println("RunningAvg :" + e);
		}
	}
}
