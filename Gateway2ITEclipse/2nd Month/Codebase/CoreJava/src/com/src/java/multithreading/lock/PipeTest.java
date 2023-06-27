package com.src.java.multithreading.lock;

import java.io.PipedInputStream;
import java.io.PipedOutputStream;

public class PipeTest {
	public static void main(String[] args) {
		try {
			PipedOutputStream pos = new PipedOutputStream();
			PipedInputStream pis = new PipedInputStream(pos);

			NumGen numgen = new NumGen(pos);
			RunningAvg runavg = new RunningAvg(pis);
			numgen.start();
			runavg.start();
		} catch (Exception e) {
			System.out.println("Exception occured...");
		}
	}
}
