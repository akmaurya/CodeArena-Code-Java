package com.src.java.immutable;

public class ImmutableClass {
	final private int varX;
	final private int varY;

	ImmutableClass(int x, int y) {
		this.varX = x;
		this.varY = y;
	}

	public final int getX() {
		return varX;
	}

	public final int getY() {
		return varY;
	}
}
