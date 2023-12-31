package com.src.java.collection.stack;

/**
 * 
 * @author Generic type of Stack class
 *
 * @param <E>
 */
public class Stack<E> {
	private final int size;

	private int top;

	private E[] elements;

	public Stack() {
		this(10);
	}

	@SuppressWarnings("unchecked")
	public Stack(final int size) {
		this.size = size > 0 ? size : 10;
		top = -1;

		elements = (E[]) new Object[this.size]; // create array
	}

	public void push(E pushValue) {
		if (top == size - 1) // if stack is full
			throw new FullStackException(String.format("Stack is full, cannot push %s", pushValue));

		elements[++top] = pushValue; // place pushValue on Stack
	}

	public E pop() {
		if (top == -1) // if stack is empty
			throw new EmptyStackException("Stack is empty, cannot pop");

		return elements[top--]; // remove and return top element of Stack
	}
}
