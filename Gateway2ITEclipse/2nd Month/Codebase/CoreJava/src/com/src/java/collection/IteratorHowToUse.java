package com.src.java.collection;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

public class IteratorHowToUse {
	public static void main(String args[]) {

		// This is nice way to create List, but it's fixed length, don't support
		// remove()
		List<String> androidVersions = Arrays.asList("Petit Four", "Cupcake", "Donut", "Eclair", "Froyo",
				"Gingerbread", "Honeycomb", "Ice Cream Sandwich", "Jelly Bean");

		// this is better than adding individual elements
		List<String> android = new ArrayList<String>(androidVersions);

		// Getting Iterator from List
		Iterator<String> iterator = android.iterator();

		System.out.println("Size of List before Iteration " + android.size());

		// Using Iterator to iterate over List, access object one by one
		while (iterator.hasNext()) {
			String version = iterator.next();
			System.out.println(version);
			
			// removing object from List - ConcurrentModificationException
			android.remove(version);

			iterator.remove(); // you should be using Iterator's remove method
		}

		System.out.println("Size of list after removing object during Iteration : " + android.size());
	}
}
