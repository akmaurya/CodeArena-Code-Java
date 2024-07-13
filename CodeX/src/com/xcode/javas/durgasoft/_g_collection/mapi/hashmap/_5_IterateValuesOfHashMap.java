package com.xcode.javas.durgasoft._g_collection.mapi.hashmap;

/**
 * Created by jarvis on 7/7/17.
 */
/*
  Iterate through the values of Java HashMap example
  This Java Example shows how to iterate through the values contained in the
  HashMap object.
*/

import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;

public class _5_IterateValuesOfHashMap {

    public static void main(String[] args) {

        //create HashMap object
        HashMap hMap = new HashMap();

        //add key value pairs to HashMap
        hMap.put("1","One");
        hMap.put("2","Two");
        hMap.put("3","Three");

        System.out.println(hMap);
    /*
      get Collection of values contained in HashMap using
      Collection values() method of HashMap class
    */
        Collection c = hMap.values();

        //obtain an Iterator for Collection
        Iterator itr = c.iterator();

        //iterate through HashMap values iterator
        while(itr.hasNext())
            System.out.println(itr.next());

        Collection cll = hMap.entrySet();

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
Three
Two
One
*/