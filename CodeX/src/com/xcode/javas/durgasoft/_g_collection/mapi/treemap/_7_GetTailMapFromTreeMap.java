package com.xcode.javas.durgasoft._g_collection.mapi.treemap;

/**
 * Created by jarvis on 7/7/17.
 */
/*
  Get Tail Map from Java TreeMap example
  This Java Example shows how to get the portion of TreeMap whose keys
  are grater than or equal to the specified key using tailMap method
  of Java TreeMap class.
*/

import java.util.SortedMap;
import java.util.TreeMap;

public class _7_GetTailMapFromTreeMap {

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
      To get a Tail Map from Java TreeMap use,
      SortedMap tailMap(Object fromKey) method of Java TreeMap class.

      This method returns the portion of TreeMap whose keys are grater than
      or equal to fromKey.

      Please note that, the SortedMap returned by this method is backed by
      the original TreeMap. So any changes made to SortedMap will be
      reflected back to original TreeMap.
    */
        System.out.println(treeMap);
        SortedMap sortedMap = treeMap.tailMap("2");

        System.out.println("Tail Map Contains : " + sortedMap);

    /*
      Please also note that,
      - SortedMap throws IllegalArgumentException for any attempts to insert the
      key less than fromKey.

      - subMap throws ClassCastException, if fromKey can not be compared using
      Map's Comparators
    */


    }
}

/*
Output would be
Tail Map Contains : {2=Two, 3=Three, 4=Four, 5=Five}
*/
