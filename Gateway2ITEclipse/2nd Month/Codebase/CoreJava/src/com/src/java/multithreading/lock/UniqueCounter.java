package com.src.java.multithreading.lock;

import java.util.concurrent.atomic.AtomicInteger;

public class UniqueCounter implements Counter{
	private final AtomicInteger counter = new AtomicInteger();

	@Override
	public int getCount() {
		return counter.get();
	}
	
	@Override
	public final int increment(){
		return counter.incrementAndGet();
	}
	
	@Override
	public final int decrement(){
		return counter.decrementAndGet();
	}
}
