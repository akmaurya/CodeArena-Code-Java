package com.xcode.javas.durgasoft._g_collection.mapi.hashtable;

/**
 * Created by jarvis on 7/7/17.
 */
/*
  Iterate through values of Java Hashtable example
  This Java Example shows how to iterate through the values contained in the
  Hashtable object.
*/

import java.util.Hashtable;
import java.util.Enumeration;

public class _8_IterateValuesOfHashtable {

    public static void main(String[] args) {

        //create Hashtable object
        Hashtable ht = new Hashtable();

        //add key value pairs to Hashtable
        ht.put("1","One");
        ht.put("2","Two");
        ht.put("3","Three");

    /*
      get Enumeration of values contained in Hashtable using
      Enumeration elements() method of Hashtable class
    */
        Enumeration e = ht.elements();


        //iterate through Hashtable values Enumeration
        while(e.hasMoreElements())
            System.out.println(e.nextElement());

    }
}

/*
Output would be
Three
Two
One
*/