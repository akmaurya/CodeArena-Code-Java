package com.xcode.javas.durgasoft._g_collection.mapi.treemap;

/**
 * Created by jarvis on 7/7/17.
 */
/*
  Get Size of Java TreeMap Example
  This Java Example shows how to get the size or nubmer of key value pairs
  stored in TreeMap using size method.
*/

import java.util.TreeMap;

public class _5_GetSizeOfTreeMap {

    public static void main(String[] args) {

        //create TreeMap object
        TreeMap treeMap = new TreeMap();

    /*
      To get the size of TreeMap use
      int size() method of TreeMap class. It returns the number of key value
      pairs stored in TreeMap object.
    */
        System.out.println(treeMap);
        System.out.println("Size of TreeMap : " + treeMap.size());

        //add key value pairs to TreeMap using put method
        treeMap.put("1","One");
        treeMap.put("2","Two");
        treeMap.put("3","Three");
        System.out.println(treeMap);
        System.out.println("Size of TreeMap after addition : " + treeMap.size());

        //remove one element from TreeMap using remove method
        Object obj = treeMap.remove("2");
        System.out.println(treeMap);
        System.out.println("Size of TreeMap after removal : " + treeMap.size());
    }
}

/*
Output would be
Size of TreeMap : 0
Size of TreeMap after addition : 3
Size of TreeMap after removal : 2
*/