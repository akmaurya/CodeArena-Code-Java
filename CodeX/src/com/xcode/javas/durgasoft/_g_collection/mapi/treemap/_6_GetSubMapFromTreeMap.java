package com.xcode.javas.durgasoft._g_collection.mapi.treemap;

/**
 * Created by jarvis on 7/7/17.
 */
/*
  Get Sub Map from Java TreeMap example
  This Java Example shows how to get the sub Map from Java Treemap by giving specific
  range of keys using subMap method of Java TreeMap class.
*/

import java.util.TreeMap;
import java.util.SortedMap;

public class _6_GetSubMapFromTreeMap{

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
      To get the sub Map from Java TreeMap use,
      SortedMap subMap(int fromKey, int toKey) method of TreeMap class.

      This method returns portion of the TreeMap whose keys range from
      fromKey (inclusive) to toKey(exclusive).

      Please note that, the SortedMap returned by this method is backed by
      the original TreeMap. So any changes made to SortedMap will be
      reflected back to original TreeMap.
    */

        System.out.println(treeMap);
        SortedMap sortedMap = treeMap.subMap("2","5");

        System.out.println("SortedMap Contains : " + sortedMap);

    /*
      Please also note that,
      - SortedMap throws IllegalArgumentException for any attempts to insert the
      key less than fromKey and grater than or equal to toKey.

      - subMap throws ClassCastException, if fromKey and toKey can not be
      compared using Map's Comparators

      - subMap throws IllegalArgumentException, if fromKey is grater than toKey
    */


    }
}

/*
Output would be
SortedMap Contains : {2=Two, 3=Three, 4=Four}
*/