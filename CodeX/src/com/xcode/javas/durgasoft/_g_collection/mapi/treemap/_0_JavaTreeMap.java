package com.xcode.javas.durgasoft._g_collection.mapi.treemap;

/**
 * Created by jarvis on 7/7/17.
 */
/*
  Simple Java TreeMap example
  This simple Java Example shows how to use Java TreeMap. It also describes how to
  add something to TreeMap and how to retrieve the value added from TreeMap.
*/

import java.util.TreeMap;

public class _0_JavaTreeMap {

    public static void main(String[] args) {

        //create object of TreeMap
        TreeMap treeMap = new TreeMap();

    /*
      Add key value pair to TreeMap using,
      Object put(Object key, Object value) method of Java TreeMap class,
      where key and value both are objects
      put method returns Object which is either the value previously tied
      to the key or null if no value mapped to the key.
    */

        treeMap.put("Two", new Integer(2));
        treeMap.put("One", new Integer(1));


    /*
      Please note that put method accepts Objects. Java Primitive values CAN NOT
      be added directly to TreeMap. It must be converted to corrosponding
      wrapper class first.
    */

        System.out.println(treeMap);
        //retrieve value using Object get(Object key) method of Java TreeMap class
        Object obj = treeMap.get("Two");
        System.out.println(obj);

    /*
      Please note that the return type of get method is an Object. The value must
      be casted to the original class.
    */
    }
}
/*
Output of the program would be
2
*/