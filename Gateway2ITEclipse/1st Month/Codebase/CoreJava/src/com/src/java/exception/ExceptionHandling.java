package com.src.java.exception;

import java.io.FileNotFoundException;
import java.io.IOException;

public class ExceptionHandling {

	/**
	 * 
	 * @param args
	 * @throws IOException
	 * @throws FileNotFoundException
	 */
	public static void main(String[] args) throws IOException, FileNotFoundException {
		try {
			testException(-5);
			testException(13); // Code will not execute since exception occured in above code
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			System.out.println("Releasing resources");
		}
		testException(15);
	}

	public static void testException(final int varX) throws FileNotFoundException, IOException {
		if (varX < 0) {
			FileNotFoundException myException = new FileNotFoundException("Negative Integer " + varX);
			throw myException;
		} else if (varX > 10 && varX < 15) {
			throw new IOException("Only supported for index 10 to 15");
		} else {
			System.out.println("No exception occured...");
		}
	}
}
