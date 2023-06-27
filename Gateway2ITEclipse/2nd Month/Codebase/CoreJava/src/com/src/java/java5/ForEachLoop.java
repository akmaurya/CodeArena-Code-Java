package com.src.java.java5;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class ForEachLoop {
	public static void main(String[] args) {
		List<String> keyList = new ArrayList<String>();
		keyList.add("a");

		List<String> valueList = new ArrayList<String>();
		valueList.add("b");
		valueList.add("c");

		Map<String, String> map = new HashMap<String, String>();

		// Exception in thread "main" java.util.NoSuchElementException
//		for (Iterator<String> i = keyList.iterator(); i.hasNext();) {
//			for (Iterator<String> j = valueList.iterator(); j.hasNext();) {
//				map.put(i.next(), j.next());
//			}
//		}

		for (String iStr : keyList) {
			for (String jStr : valueList) {
				map.put(iStr, jStr);
				System.out.println("Key [" + iStr + "] --- Value[" + jStr + "]");
			}
		}
	}

}
