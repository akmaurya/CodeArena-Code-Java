package com.hftsolution.SpringBeansWithAnnotation;

public class ThreadWorking {

	ThreadWorking() {
		Runnable t = () -> {

		};
		new Thread(t).start();
	}

	public void thread() {
		Runnable t = () -> {

		};
		new Thread(t).start();

	}
}
