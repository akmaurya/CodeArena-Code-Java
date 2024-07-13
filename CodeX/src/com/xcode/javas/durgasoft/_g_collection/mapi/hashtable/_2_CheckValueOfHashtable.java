package com.xcode.javas.durgasoft._g_collection.mapi.hashtable;

/**
 * Created by jarvis on 7/7/17.
 */
/*
  Check if a particular value exists in Java Hashtable example
  This Java Example shows how to check if Hashtable object contains a particular
  value using contains method of Hashtable class.
*/

import java.util.Hashtable;

public class _2_CheckValueOfHashtable {

    public static void main(String[] args) {

        //create Hashtable object
        Hashtable ht = new Hashtable();

        //add key value pairs to Hashtable
        ht.put("1","One");
        ht.put("2","Two");
        ht.put("3","Three");

    /*
      To check whether a particular value exists in Hashtable use
      boolean contains(Object key) method of Hashtable class.
      It returns true if the value is mapped to one or more keys in the
      Hashtable otherwise false.
    */
        System.out.println(ht);
        boolean blnExists = ht.contains("Two");
        System.out.println("Two exists in Hashtable ? : " + blnExists);
    }
}

/*
Output would be
Two exists in Hashtable ? : true
*/