package com.src.java.basics;

public class ExplicitlyNarrowing {
	private static short methodOne(long l) {
		int i = (int) l; // long is explicitly narrowed to int
		return (short) i; // int is explicitly narrowed to short
	}

	public static void main(String[] args) {
		double d = 10.25;
		float f = (float) d; // double is explicitly narrowed to float
		byte b = (byte) methodOne((long) f); // float is explicitly narrowed to
												// long and short to byte
		System.out.println(b);
	}
}
