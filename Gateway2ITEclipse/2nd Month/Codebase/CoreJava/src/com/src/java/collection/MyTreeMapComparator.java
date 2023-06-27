package com.src.java.collection;

import java.util.Comparator;
import java.util.TreeMap;

public class MyTreeMapComparator {
	public static void main(String a[]){
        //the treemap sorts by key
        TreeMap<String, String> map = new TreeMap<String, String>(new MyComparator());
        //add key-value pair to TreeMap
        map.put("java", "language");
        map.put("computer", "machine");
        map.put("india","country");
        map.put("mango","fruit");
        System.out.println(map);
    }
}

class MyComparator implements Comparator<String>{
	 
    @Override
    public int compare(String str1, String str2) {
        return str1.compareTo(str2);
    }
}
