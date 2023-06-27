package com.src.java.collection;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.TreeMap;

public class SortMapByKeyAndValue {
	public static void main(String a[]) {
		
		Map<String, Integer> map = new HashMap<String, Integer>();
		long startTime = System.nanoTime();
		map.put("Java", 20);
		map.put("C++", 45);
		map.put("Java2Novice", 2);
		map.put("Why this kolavari", 67);
		map.put("MAC", 26);
		map.put("Unix", 93);

		System.out.println("Sort Map by key: ");
		sortMapByKey(map);
		
		System.out.println("\nSort Map by value: ");
		sortMapByValue(map);
        long endTime = System.nanoTime();
        System.out.println("Total time to Process HashMap in sec : "
                            + (endTime - startTime));
		
		System.out.println("\n\nTreeMap Example - ");
		startTime = System.nanoTime();
		map = new TreeMap<String, Integer>();
		map.put("Java", 20);
		map.put("C++", 45);
		map.put("Java2Novice", 2);
		map.put("Why this kolavari", 67);
		map.put("MAC", 26);
		map.put("Unix", 93);

		System.out.println("Sort Map by key: ");
		sortMapByKey(map);
		
		System.out.println("\nSort Map by value: ");
		sortMapByValue(map);
		endTime = System.nanoTime();
        System.out.println("Total time to Process TreeMap in sec : "
                            + (endTime - startTime));
	}
	
	private static void sortMapByKey(Map<String, Integer> map) {
		Set<Entry<String, Integer>> set = map.entrySet();
		List<Entry<String, Integer>> list = new ArrayList<Entry<String, Integer>>(set);

		// Collections.sort expect list as first argument
		Collections.sort(list, new Comparator<Map.Entry<String, Integer>>() {
			public int compare(Map.Entry<String, Integer> o1, Map.Entry<String, Integer> o2) {
				return (o2.getKey()).compareTo(o1.getKey());
			}
		});

		for (Map.Entry<String, Integer> entry : list) {
			System.out.println(entry.getKey() + " ==== " + entry.getValue());
		}
	}

	private static void sortMapByValue(Map<String, Integer> map) {
		Set<Entry<String, Integer>> set = map.entrySet();
		List<Entry<String, Integer>> list = new ArrayList<Entry<String, Integer>>(set);

		// Collections.sort expect list as first argument
		Collections.sort(list, new Comparator<Map.Entry<String, Integer>>() {
			public int compare(Map.Entry<String, Integer> o1, Map.Entry<String, Integer> o2) {
				return (o2.getValue()).compareTo(o1.getValue());
			}
		});

		for (Map.Entry<String, Integer> entry : list) {
			System.out.println(entry.getKey() + " ==== " + entry.getValue());
		}
	}
}
