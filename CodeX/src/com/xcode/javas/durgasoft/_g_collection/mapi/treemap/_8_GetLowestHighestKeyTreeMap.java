package com.xcode.javas.durgasoft._g_collection.mapi.treemap;

/**
 * Created by jarvis on 7/7/17.
 */
/*
  Get lowest and highest key stored in Java TreeMap example
  This Java Example shows how to get the lowest and highest key stored in the java
  TreeMap object using firstKey and lastKey methods of java TreeMap class.
*/

import java.util.TreeMap;

public class _8_GetLowestHighestKeyTreeMap {

    public static void main(String[] args) {

        //create TreeMap object
        TreeMap treeMap = new TreeMap();

        //add key value pairs to TreeMap
        treeMap.put("1","One");
        treeMap.put("3","Three");
        treeMap.put("2","Two");
        treeMap.put("5","Five");
        treeMap.put("4","Four");

    /*
      To get the lowest key currently stored in Java TreeMap use,
      Object firstKey() method of TreeMap class.

      This method returns the first or lowest key currently stored in the
      TreeMap object.
    */
        System.out.println(treeMap);
        System.out.println("Lowest key Stored in Java TreeMap is : " + treeMap.firstKey());

    /*
      To get the highest key currently stored in Java TreeMap use,
      Object lastKey() method of TreeMap class.

      This method returns the last or highest key currently stored in the
      TreeMap object.
    */

        System.out.println("Highest key Stored in Java TreeMap is : " + treeMap.lastKey());

    }
}

/*
Output would be
Lowest key Stored in Java TreeMap is : 1
Highest key Stored in Java TreeMap is : 5
*/
