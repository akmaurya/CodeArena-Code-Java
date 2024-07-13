package com.xcode.javas.durgasoft._g_collection.mapi.treemap;

/**
 * Created by jarvis on 7/7/17.
 */
/*
  Remove all values from Java TreeMap example
  This Java Example shows how to remove all values from TreeMap object or empty
  TreeMap or clear TreeMap using clear method.
*/

import java.util.TreeMap;

public class _10_EmptyTreeMap {

    public static void main(String[] args) {

        //create TreeMap object
        TreeMap treeMap = new TreeMap();

        //add key value pairs to TreeMap
        treeMap.put("1","One");
        treeMap.put("2","Two");
        treeMap.put("3","Three");

    /*
      To remove all values or clear TreeMap use
      void clear method() of TreeMap class. Clear method removes all
      key value pairs contained in TreeMap.
    */
        System.out.println(treeMap);

        treeMap.clear();
        System.out.println(treeMap);
        System.out.println("Total key value pairs in TreeMap are : " + treeMap.size());
    }
}

/*
Output would be
Total key value pairs in TreeMap are : 0
*/