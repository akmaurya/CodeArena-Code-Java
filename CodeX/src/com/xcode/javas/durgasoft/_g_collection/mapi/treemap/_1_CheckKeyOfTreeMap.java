package com.xcode.javas.durgasoft._g_collection.mapi.treemap;

/**
 * Created by jarvis on 7/7/17.
 */
/*
  Check if a particular key exists in Java TreeMap example
  This Java Example shows how to check if TreeMap object contains a particular
  key using containsKey method of TreeMap class.
*/

import java.util.TreeMap;

public class _1_CheckKeyOfTreeMap {

    public static void main(String[] args) {

        //create TreeMap object
        TreeMap treeMap = new TreeMap();

        //add key value pairs to TreeMap
        treeMap.put("1","One");
        treeMap.put("2","Two");
        treeMap.put("3","Three");

    /*
      To check whether a particular key exists in TreeMap use
      boolean containsKey(Object key) method of TreeMap class.
      It returns true if the TreeMap contains mapping for specified key
      otherwise false.
    */
        System.out.println(treeMap);

        boolean blnExists = treeMap.containsKey("1");
        System.out.println("1 exists in TreeMap ? : " + blnExists);
    }
}

/*
Output would be
1 exists in TreeMap ? : true
*/