package com.src.java.collection;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class SwapArrayList {
	public static void main(String[] args) {
		List<String> list = new ArrayList<String>();
		list.add("Java");
		list.add("Cric");
		list.add("Play");
		list.add("Watch");
		list.add("Glass");
		list.add("Movie");
		list.add("Girl");
		list.add("Girl");

		Collections.swap(list, 2, 5);
		System.out.println("Results after swap operation:");
		for (String str : list) {
			System.out.println(str);
		}
	}
}
