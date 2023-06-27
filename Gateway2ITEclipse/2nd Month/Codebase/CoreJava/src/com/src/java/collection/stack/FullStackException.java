package com.src.java.collection.stack;

@SuppressWarnings("serial")
class FullStackException extends RuntimeException {
	public FullStackException() {
		this("Stack is full");
	}

	public FullStackException(String exception) {
		super(exception);
	}
}