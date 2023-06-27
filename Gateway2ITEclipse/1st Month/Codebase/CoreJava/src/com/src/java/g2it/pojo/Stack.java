package com.src.java.g2it.programs.pojo;

public class Stack {
	private int data[] = new int[50];
	int ptr = 0;
	
	public void push(int value) {
		if(ptr > 49) {
			System.out.println("Stack is Full...");
			return;
		}
		this.data[ptr++] = value;
	}
	
	public int pop() {
		if(ptr == 0) {
			System.out.println("Stack is empty...");
			return -10;
		}
		return this.data[--ptr];
	}
	
	public int peek() {
		return this.data[ptr];
	}
	
	public int getSize() {
		return ptr;
	}
}
