package com.src.java.collection;

import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.WeakHashMap;

public class WeakHashMapExample {
	public static void main(String[] args) {
		// Weak References
		Map<Object, String> map = new WeakHashMap<Object, String>();
		// Strong References
		// Map<Object, String> map = new HashMap<Object, String>();

		// Strong References
		Object key1 = new Object();
		String key2 = new String("key2");

		map.put(key1, "one");
		map.put(key2, "two");

		key1 = null;
		key2 = null;

		System.gc();

		System.out.println("Size of Map is:" + map.size());
		Set<Object> set = map.keySet();
		Iterator<Object> itr = set.iterator();
		while (itr.hasNext()) {
			Object key = itr.next();
			System.out.println("Key-" + key + "--- Value-" + map.get(key));
		}
	}
}
