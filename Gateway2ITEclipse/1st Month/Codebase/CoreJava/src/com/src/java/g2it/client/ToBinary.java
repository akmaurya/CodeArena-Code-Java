package com.src.java.g2it.programs.client;

import com.src.java.g2it.programs.pojo.Stack;

public class ToBinary {
	public Stack getBinary(int value) {
		Stack stack = new Stack();
		while(value >= 1) {
			stack.push(value % 2);
			value = value / 2;
		}
		
		return stack;
	}
	
	public static void main(String[] args) {
		Stack stack = new ToBinary().getBinary(10);
		
		for(int index = stack.getSize(); index > 0; index--) {
			System.out.print(stack.pop() + "  ");
		}
	}
}
