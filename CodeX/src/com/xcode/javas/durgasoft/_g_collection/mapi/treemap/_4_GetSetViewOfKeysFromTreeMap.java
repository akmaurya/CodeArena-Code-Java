package com.xcode.javas.durgasoft._g_collection.mapi.treemap;

/**
 * Created by jarvis on 7/7/17.
 */
/*
  Get Set view of Keys from Java TreeMap example
  This Java Example shows how to get a Set of keys contained in TreeMap
  using keySet method of Java TreeMap class.
*/

import java.util.Iterator;
import java.util.TreeMap;
import java.util.Set;

public class _4_GetSetViewOfKeysFromTreeMap {

    public static void main(String[] args) {

        //create TreeMap object
        TreeMap treeMap = new TreeMap();

        //add key value pairs to TreeMap
        treeMap.put("1","One");
        treeMap.put("3","Three");
        treeMap.put("2","Two");

    /*
      get Set of keys contained in TreeMap using
      Set keySet() method of TreeMap class
    */

        System.out.println(treeMap);
        Set st = treeMap.keySet();

        System.out.println("Set created from TreeMap Keys contains :");

    /*
      Iterate through the Set of keys.
      Please note that Set's iterator will return the keys in ascending order.
    */
        Iterator itr = st.iterator();
        while(itr.hasNext())
            System.out.println(itr.next());

    /*
       Please note that resultant Set object is backed by the TreeMap.
       Any key that is removed from Set will also be removed from
       original TreeMap object. The same is not the case with the element
       addition.
    */

        //remove 1 from Set
        st.remove("1");

        //check if original TreeMap still contains 2
        boolean blnExists = treeMap.containsKey("1");
        System.out.println(treeMap);
        System.out.println("Does TreeMap contain 1 ? " + blnExists);
    }
}

/*
Output would be
Set created from TreeMap Keys contains :
1
2
3
Does TreeMap contain 1 ? false
*/