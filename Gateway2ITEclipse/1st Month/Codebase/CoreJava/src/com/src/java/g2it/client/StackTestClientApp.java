package com.src.java.g2it.programs.client;

import com.src.java.g2it.programs.pojo.Stack;

public class StackTestClientApp {
	public static void main(String[] args) {
		Stack stack = new Stack();
		stack.push(10);
		stack.push(20);
		stack.push(5);
		stack.push(7);
		
		System.out.println(stack.pop());
		System.out.println(stack.pop());
		System.out.println(stack.pop());
		System.out.println(stack.peek());
		stack.push(120);
		stack.push(50);
		System.out.println(stack.peek());
		System.out.println(stack.pop());
	}
}
