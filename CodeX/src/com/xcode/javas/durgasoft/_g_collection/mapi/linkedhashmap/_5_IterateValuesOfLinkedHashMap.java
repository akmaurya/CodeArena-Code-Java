package com.xcode.javas.durgasoft._g_collection.mapi.linkedhashmap;

/**
 * Created by jarvis on 7/7/17.
 */
/*
  Iterate through the values of Java LinkedHashMap example
  This Java Example shows how to iterate through the values contained in the
  LinkedHashMap object.
*/

import java.util.Collection;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Iterator;

public class _5_IterateValuesOfLinkedHashMap {

    public static void main(String[] args) {

        //create LinkedHashMap object
        LinkedHashMap lHashMap = new LinkedHashMap();

        //add key value pairs to LinkedHashMap
        lHashMap.put("1","One");
        lHashMap.put("2","Two");
        lHashMap.put("3","Three");

    /*
      get Collection of values contained in LinkedHashMap using
      Collection values() method of LinkedHashMap class
    */
        System.out.println(lHashMap);
        Collection c = lHashMap.values();

        //obtain an Iterator for Collection
        Iterator itr = c.iterator();

        //iterate through LinkedHashMap values iterator
        while(itr.hasNext())
            System.out.println(itr.next());


        Collection cll = lHashMap.entrySet();
        Iterator itr1 = cll.iterator();
        while (itr1.hasNext())
        {
            HashMap.Entry ent = (HashMap.Entry)itr1.next();
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