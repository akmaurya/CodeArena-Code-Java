package com.src.java.collection;

import java.util.Hashtable;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public class HashTableDemo {

	public static void main(String[] args) {
		Map<String, String> testMap = new Hashtable<String, String>();

		testMap.put("1", "ONE");
		testMap.put("2", "TWO");
		testMap.put("2", "TWO NEW");
//		testMap.put("3", null);
//		testMap.put("4", null);
//		testMap.put(null, "NULL VALUE");
//		testMap.put(null, "AGAIN NULL");

		System.out.println(testMap.get("2"));
		System.out.println(testMap.get("3"));
		System.out.println(testMap.get("4"));
		//System.out.println(testMap.get(null));

		Set<String> keySet = testMap.keySet();
		Iterator<String> itr = keySet.iterator();
		System.out.println("\nSize of Map : " + testMap.size());
		while (itr.hasNext()) {
			String key = itr.next();
			System.out.println("Key- " + key + " --- Value - " + testMap.get(key));
		}

		// Using Map.Entry interface
		System.out.println("\nUsing Map.Entry interface - ");
		for (Map.Entry<String, String> mapEntry : testMap.entrySet()) {
			System.out.println("Key- " + mapEntry.getKey() + " --- Value - " + mapEntry.getValue());
		}
	}

}
