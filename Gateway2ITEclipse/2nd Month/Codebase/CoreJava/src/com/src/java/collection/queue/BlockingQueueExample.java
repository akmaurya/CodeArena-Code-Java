package com.src.java.collection.queue;

import java.util.Random;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.CountDownLatch;

/**
 * This example generates immutable SimpleAddition objects that require an
 * addition of two numbers to be performed on the consumer thread. In this case
 * the two values to be added are generated using java.util.Random's nextInt
 * call. They are stored on the queue as a SimpleAddition transfer object and
 * picked up for processing on the consumer thread.
 */
public class BlockingQueueExample {
	// the maximum number of items that can be on the queue
	private static final int MAX_CAPACITY = 3;

	// the number of items to queue, make larger than capacity
	private static final int ITEMS_TO_QUEUE = 5000;

	// create a bounded queue based on an array.
	private BlockingQueue<SimpleAddition> queue = new ArrayBlockingQueue<SimpleAddition>(MAX_CAPACITY);

	/**
	 * CountDownLatch is a synchronization aid that allows one or more threads
	 * to wait until a set of operations being performed in other threads
	 * completes. CountDownLatch works by having a counter initialized with
	 * number of threads, which is decremented each time a thread complete its
	 * execution. When count reaches to zero, it means all threads have
	 * completed their execution, and thread waiting on latch resume the
	 * execution.
	 */
	// a latch that counts down the items we have processed
	private CountDownLatch consumeLatch = new CountDownLatch(ITEMS_TO_QUEUE);

	// and a random number generator for creating addition instances
	private Random random = new Random(System.currentTimeMillis());

	public static void main(String[] args) throws InterruptedException {
		BlockingQueueExample example = new BlockingQueueExample();
		example.init();
		System.out.println("Main is ended...");
	}

	public void init() throws InterruptedException {
		// run the consumer thread, there could be more than one consumer
		Thread th = new Thread(new QueueProcessor(), "QueueProcessor");
		th.setDaemon(true); // don't hold the VM open for this thread
		th.start();

		// and load the queue with some values, should the queue fill
		// up, the put call will block.
		for (int i = 0; i < ITEMS_TO_QUEUE; i++) {
			SimpleAddition addition = new SimpleAddition(random.nextInt(128), random.nextInt(128));
			queue.put(addition);
			System.out.println("Queued...");
			//Thread.sleep(2000);
		}

		/**
		 * The first interaction with CountDownLatch is with main thread which
		 * is going to wait for other threads. This main thread must call,
		 * CountDownLatch.await() method immediately after starting other
		 * threads. The execution will stop on await() method till the time,
		 * other threads complete their execution.
		 */
		// This latch counts down each event in the producer, and once
		// all the events are processed we exit the VM.
		consumeLatch.await();		
	}

	/**
	 * This runnable simulates the real world producer, it takes items of work
	 * from the queue and processes them. In a real world system there could
	 * well be more than one processor thread.
	 */
	private class QueueProcessor implements Runnable {
		@Override
		public void run() {
			try {
				while (!Thread.currentThread().isInterrupted()) {
					// attempt to take the next work item off the queue
					// if we consume quicker than the producer then take
					// will block until there is work to do.
					SimpleAddition addition = queue.take();
					// and now do the work!
					int result = addition.getN1() + addition.getN2();
					System.out.printf("Addition: %d + %d = %d", addition.getN1(), addition.getN2(), result);
					System.out.println();

					/**
					 * Other N threads must have reference of latch object,
					 * because they will need to notify the CountDownLatch
					 * object that they have completed their task. This
					 * notification is done by method :
					 * CountDownLatch.countDown(); Each invocation of method
					 * decreases the initial count set in constructor, by 1. So,
					 * when all N threads have call this method, count reaches
					 * to zero, and main thread is allowed to resume its
					 * execution past await() method.
					 */
					// decrement the countdown latch
					consumeLatch.countDown();
				}
			} catch (InterruptedException e) {
				e.printStackTrace();
				// no need to re set interrupted as we are outside loop
			}
		}
	}

	/**
	 * This immutable object is used to pass the state over to the queue
	 * processor. Made a static inner class to avoid the overhead of access back
	 * to the instance.
	 */
	private final static class SimpleAddition {
		private final int n1;
		private final int n2;

		public SimpleAddition(int n1, int n2) {
			this.n1 = n1;
			this.n2 = n2;
		}

		private int getN1() {
			return n1;
		}

		private int getN2() {
			return n2;
		}
	}
}