package com.xcode.javas.durgasoft._g_collection.mapi.linkedhashmap;

/**
 * Created by jarvis on 7/7/17.
 */
/*
  Remove all values from Java LinkedHashMap example
  This Java Example shows how to remove all values from LinkedHashMap object or empty
  LinkedHashMap or clear LinkedHashMap using clear method.
*/

import java.util.LinkedHashMap;

public class _6_EmptyLinkedHashMap {

    public static void main(String[] args) {

        //create LinkedHashMap object
        LinkedHashMap lHashMap = new LinkedHashMap();

        //add key value pairs to LinkedHashMap
        lHashMap.put("1","One");
        lHashMap.put("2","Two");
        lHashMap.put("3","Three");

    /*
      To remove all values or clear LinkedHashMap use
      void clear method() of LinkedHashMap class. Clear method removes all
      key value pairs contained in LinkedHashMap.
    */
        System.out.println(lHashMap);

        lHashMap.clear();

        System.out.println("Total key value pairs in LinkedHashMap are : " + lHashMap.size());
    }
}

/*
Output would be
Total key value pairs in LinkedHashMap are : 0
*/