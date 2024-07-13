package com.xcode.javas.durgasoft._g_collection.mapi.treemap;

/**
 * Created by jarvis on 7/7/17.
 */
/*
  Get Head Map from Java TreeMap example
  This Java Example shows how to get the portion of TreeMap whose keys are less than
  the specified key using headMap method of Java TreeMap class.
*/

import java.util.SortedMap;
import java.util.TreeMap;

public class _3_GetHeadMapFromTreeMap {

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
      To get a Head Map from Java TreeMap use,
      SortedMap headMap(Object toKey) method of Java TreeMap class.

      This method returns the portion of TreeMap whose keys are less than
      toKey.

      Please note that, the SortedMap returned by this method is backed by
      the original TreeMap. So any changes made to SortedMap will be
      reflected back to original TreeMap.
    */
        System.out.println(treeMap);

        SortedMap sortedMap = treeMap.headMap("3");

        System.out.println("Head Map of 3 Contains : " + sortedMap);

    /*
      Please also note that,
      - SortedMap throws IllegalArgumentException for any attempts to insert the
      key grater than or equal to toKey.

      - subMap throws ClassCastException, if toKey can not be compared using
      Map's Comparators
    */


    }
}

/*
Output would be
Head Map Contains : {1=One, 2=Two}
*/