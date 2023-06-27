package com.src.java.exception;

public class FinallyBlockAlwaysExecute {
	public static void main(String[] args) {
		
		// Scenario - 1
		try {
			System.out.println(1/0);
		} catch (Exception ex) {
			System.out.println("Exception occured - " + ex);
		} finally {
			System.out.println("finally block will execute always.");
		}
		
		// Scenario - 2 with System.exit(0)
//		try {
//			System.out.println(1/0);
//		} catch (Exception ex) {
//			System.out.println("Exception occured - " + ex);
//			System.exit(0);
//		} finally {
//			System.out.println("finally block will execute always.");
//		}
		
		// Scenario - 3 with Return
//		try {
//			System.out.println(1/0);
//		} catch (Exception ex) {
//			System.out.println("Exception occured - " + ex);
//			return;
//		} finally {
//			System.out.println("finally block will execute always.");
//		}
	}
}
