package com.src.java.g2it.programs.pyramid;

public class Pyramid4 {
	public static void main(String[] args) {
		for(int row=1; row<=5; row++) {
			for(int col=1; col<=5 - (row-1); col++) {
				System.out.print(col);
			}
			
			for(int space=1; space<(row*2)-2; space++) {
				if(row == 1) {
					continue;
				}
				System.out.print(" ");
			}
			
			for(int col=5 - (row-1); col>=1; col--) {
				if(col ==5) {
					continue;
				}
				System.out.print(col);
			}
			System.out.println();
		}
	}
}
