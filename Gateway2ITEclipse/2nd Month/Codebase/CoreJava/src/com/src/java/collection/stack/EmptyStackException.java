package com.src.java.collection.stack;

@SuppressWarnings("serial")
class EmptyStackException extends RuntimeException {
	public EmptyStackException() {
		this("Stack is empty");
	}

	public EmptyStackException(String exception) {
		super(exception);
	}
}
