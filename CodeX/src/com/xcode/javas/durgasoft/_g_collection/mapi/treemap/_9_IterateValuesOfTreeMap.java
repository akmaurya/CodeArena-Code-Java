package com.xcode.javas.durgasoft._g_collection.mapi.treemap;

/**
 * Created by jarvis on 7/7/17.
 */
/*
  Iterate through the values of Java TreeMap example
  This Java Example shows how to iterate through the values contained in the
  TreeMap object.
*/

import java.util.Collection;
import java.util.Map;
import java.util.TreeMap;
import java.util.Iterator;

public class _9_IterateValuesOfTreeMap {

    public static void main(String[] args) {

        //create TreeMap object
        TreeMap treeMap = new TreeMap();

        //add key value pairs to TreeMap
        treeMap.put("1","One");
        treeMap.put("2","Two");
        treeMap.put("3","Three");

    /*
      get Collection of values contained in TreeMap using
      Collection values() method of TreeMap class
    */
        System.out.println(treeMap);
        Collection c = treeMap.values();

        //obtain an Iterator for Collection
        Iterator itr = c.iterator();

        //iterate through TreeMap values iterator
        while(itr.hasNext())
            System.out.println(itr.next());

        Collection cll = treeMap.entrySet();
        Iterator itr1 = cll.iterator();

        while (itr1.hasNext())
        {
            Map.Entry ent = (Map.Entry)itr1.next();
            System.out.println(ent.getKey()+" = "+ent.getValue());
        }
    }
}

/*
Output would be
One
Two
Three
*/