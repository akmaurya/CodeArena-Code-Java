package com.src.java.collection;

import java.util.List;
import java.util.Vector;

public class VectorExample {
	public static void main(String[] args) {
		List<String> myList = new Vector<String>();
		// adding elements to the end
		myList.add("First");
		myList.add("Second");
		myList.add("Third");
		myList.add("Random");
		myList.add("Click");
		System.out.println("Actual vector:" + myList);
		List<String> list = myList.subList(2, 4);
		System.out.println("Sub List: " + list);
	}
}
