package java.main;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class MessageAppMain {

	public static void main(String[] args) {
		System.out.println("Test");
		ExecutorService executor = Executors.newFixedThreadPool(3);

		executor.execute(new VendorThread());
		executor.execute(new MessageThread());

//        executor.shutdown();

		while (!executor.isTerminated()) {
			// Wait for all threads to finish
		}

		// Thread 3: Process Messages for Vendors
		new VendorMessageProcessorThread().run();
	}
}
