package com.xcode.javas.durgasoft._g_collection.mapi.linkedhashmap;

/**
 * Created by jarvis on 7/7/17.
 */
/*
  Get Size of Java LinkedHashMap Example
  This Java Example shows how to get the size or nubmer of key value pairs
  stored in LinkedHashMap using size method.
*/

import java.util.LinkedHashMap;

public class _4_GetSizeOfLinkedHashMap {

    public static void main(String[] args) {

        //create LinkedHashMap object
        LinkedHashMap lHashMap = new LinkedHashMap();

    /*
      To get the size of LinkedHashMap use
      int size() method of LinkedHashMap class. It returns the number of key value
      pairs stored in LinkedHashMap object.
    */
        System.out.println(lHashMap);
        System.out.println("Size of LinkedHashMap : " + lHashMap.size());

        //add key value pairs to LinkedHashMap using put method
        lHashMap.put("1","One");
        lHashMap.put("2","Two");
        lHashMap.put("3","Three");
        System.out.println(lHashMap);
        System.out.println("Size of LinkedHashMap after addition : " + lHashMap.size());

        //remove one element from LinkedHashMap using remove method
        Object obj = lHashMap.remove("2");
        System.out.println(lHashMap);
        System.out.println("Size of LinkedHashMap after removal : " + lHashMap.size());
    }
}

/*
Output would be
Size of LinkedHashMap : 0
Size of LinkedHashMap after addition : 3
Size of LinkedHashMap after removal : 2
*/