package com.src.java.testables;

public class Rectangle {
	// State variables.
	private int height;
	private int width;

	// Constructors
	public Rectangle() {
		height = 0;
		width = 0;
	}

	public Rectangle(int h, int w) {
		height = h;
		width = w;
	}

	// Readers
	public int getH() {
		return height;
	}

	public int getW() {
		return width;
	}

	public int getA() {
		return height * width;
	}

	// Writers
	public void setH(int h) {
		height = h;
	}

	public void setW(int w) {
		width = w;
	}

	public String toString() {
		return "Rectangle: height=" + height + "; width=" + width + "; area=" + getA() + ".";
	}
}
