package com.src.java.exception;

/**
 * 
 * @author GPS
 *
 */
public class ArrayOutOfBoundException {
	public static void main(String args[]) {
		try {
			int array[] = new int[2];
			System.out.println("Access element three :" + array[3]);
		} catch (ArrayIndexOutOfBoundsException e) {
			System.out.println("Exception thrown  :" + e);
		}
		System.out.println("Out of the block");
	}
}
