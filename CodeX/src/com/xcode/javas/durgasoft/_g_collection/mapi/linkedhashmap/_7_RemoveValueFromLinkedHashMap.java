package com.xcode.javas.durgasoft._g_collection.mapi.linkedhashmap;

/**
 * Created by jarvis on 7/7/17.
 */
/*
  Remove value from Java LinkedHashMap example
  This Java Example shows how to remove a key value pair from
  LinkedHashMap object using remove method.
*/

import java.util.LinkedHashMap;

public class _7_RemoveValueFromLinkedHashMap {

    public static void main(String[] args) {

        //create LinkedHashMap object
        LinkedHashMap lHashMap = new LinkedHashMap();

        //add key value pairs to LinkedHashMap
        lHashMap.put("1","One");
        lHashMap.put("2","Two");
        lHashMap.put("3","Three");

    /*
      To remove a key value pair from LinkedHashMap use
      Object remove(Object key) method of LinkedHashMap class.
      It returns either the value mapped with the key previously or null if no value
      was mapped.
    */
        System.out.println(lHashMap);
        Object obj = lHashMap.remove("2");
        System.out.println(lHashMap);
        System.out.println(obj + " Removed from LinkedHashMap");

    }
}
/*
Output would be
Two Removed from LinkedHashMap
*/