package com.xcode.javas.durgasoft._g_collection.mapi.treemap;

/**
 * Created by jarvis on 7/7/17.
 */
/*
  Remove value from Java TreeMap example
  This Java Example shows how to remove a key value pair from TreeMap object using
  remove method.
*/

import java.util.TreeMap;

public class _11_RemoveValueFromTreeMap {

    public static void main(String[] args) {

        //create TreeMap object
        TreeMap treeMap = new TreeMap();

        //add key value pairs to TreeMap
        treeMap.put("1","One");
        treeMap.put("2","Two");
        treeMap.put("3","Three");

    /*
      To remove a key value pair from TreeMap use
      Object remove(Object key) method of TreeMap class.
      It returns either the value mapped with the key or null if no value
      was mapped.
    */
        System.out.println(treeMap);

        Object obj = treeMap.remove("2");
        System.out.println(treeMap);
        System.out.println(obj + " Removed from TreeMap");

    }
}
/*
Output would be
Two Removed from TreeMap
*/