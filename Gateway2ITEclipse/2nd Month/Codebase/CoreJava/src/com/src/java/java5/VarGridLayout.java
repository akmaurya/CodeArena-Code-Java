package com.src.java.java5;

public class VarGridLayout {
	VarGridLayout(Integer... size) {
		for (Integer i : size) {
			System.out.print(i);
		}
		System.out.println();
	}

	public static void main(String[] args) {
		System.out.println("Call no arg constructor:");
		new VarGridLayout();
		System.out.println("Call two arg constructor: 2,3");
		new VarGridLayout(2, 3);
		System.out.println("Call four arg constructor: 4,5,6,7");
		new VarGridLayout(4, 5, 6, 7);
	}
}
