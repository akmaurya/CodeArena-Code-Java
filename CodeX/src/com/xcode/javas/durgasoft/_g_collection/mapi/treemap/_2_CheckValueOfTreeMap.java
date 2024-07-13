package com.xcode.javas.durgasoft._g_collection.mapi.treemap;

/**
 * Created by jarvis on 7/7/17.
 */
/*
  Check if a particular value exists in Java TreeMap example
  This Java Example shows how to check if TreeMap object contains a particular
  value using containsValue method of TreeMap class.
*/

import java.util.TreeMap;

public class _2_CheckValueOfTreeMap {

    public static void main(String[] args) {

        //create TreeMap object
        TreeMap treeMap = new TreeMap();

        //add key value pairs to TreeMap
        treeMap.put("1","One");
        treeMap.put("2","Two");
        treeMap.put("3","Three");

    /*
      To check whether a particular value exists in TreeMap use
      boolean containsValue(Object key) method of TreeMap class.
      It returns true if the value is mapped to one or more keys in the
      TreeMap otherwise false.
    */
        System.out.println(treeMap);

        boolean blnExists = treeMap.containsValue("Three");
        System.out.println("Three exists in TreeMap ? : " + blnExists);
    }
}

/*
Output would be
Three exists in TreeMap ? : true
*/