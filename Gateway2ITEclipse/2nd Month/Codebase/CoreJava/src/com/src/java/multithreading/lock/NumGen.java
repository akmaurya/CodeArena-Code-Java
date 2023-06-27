package com.src.java.multithreading.lock;

import java.io.DataOutputStream;
import java.io.PipedOutputStream;
import java.util.Random;

public class NumGen extends Thread {
	DataOutputStream dos;

	NumGen(PipedOutputStream pos) {
		dos = new DataOutputStream(pos);
	}

	public void run() {
		try {
			Random ran = new Random();
			while (true) {
				double d = ran.nextDouble() * 1000;
				dos.writeDouble(d);
				System.out.println("Generated no is :" + d);
				sleep(1000);
			}
		} catch (Exception e) {
			System.out.println("NumGen :" + e);
		}
	}
}
