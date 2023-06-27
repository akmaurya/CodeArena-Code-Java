package com.src.java.collection;

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

public class ReadOnlyCollectionExample {
	public static void main(String args[]) {
		Set<String> set = new HashSet<String>();
		set.add("Bernadine");
		set.add("Elizabeth");
		set.add("Gene");
		set.add("Elizabeth");
		set = Collections.unmodifiableSet(set);
		set.add("Clara");
	}
}
