package com.xcode.javas.durgasoft._g_collection.mapi.hashtable;

/**
 * Created by jarvis on 7/7/17.
 */
/*
  Iterate through keys of Java Hashtable example
  This Java Example shows how to iterate through the keys contained in the
  Hashtable object.
*/

import java.util.Hashtable;
import java.util.Enumeration;

public class _7_IterateThroughKeysOfHashtable {

    public static void main(String[] args) {

        //create Hashtable object
        Hashtable ht = new Hashtable();

        //add key value pairs to Hashtable
        ht.put("1","One");
        ht.put("2","Two");
        ht.put("3","Three");

    /*
      get Enumeration of keys contained in Hashtable using
      Enumeration keys() method of Hashtable class
    */
        System.out.println(ht);
        Enumeration e = ht.keys();

        //iterate through Hashtable keys Enumeration
        while(e.hasMoreElements())
            System.out.println(e.nextElement());
    }
}

/*
Output would be
3
2
1
*/