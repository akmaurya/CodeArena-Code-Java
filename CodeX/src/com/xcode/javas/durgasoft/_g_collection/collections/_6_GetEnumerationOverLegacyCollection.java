package com.xcode.javas.durgasoft._g_collection.collections;

/**
 * Created by jarvis on 7/7/17.
 */
/*
  Get Enumeration over Java ArrayList Example
  This java example shows how to get Enumeration over Java ArrayList using
  enumeration method of Collections class. This example also shows how to enumerate
  through elements of Java ArrayList.
*/

import java.util.Enumeration;
import java.util.ArrayList;
import java.util.Collections;


public class _6_GetEnumerationOverLegacyCollection {

    public static void main(String[] args) {
        //create an ArrayList object
        ArrayList arrayList = new ArrayList();

        //Add elements to ArrayList
        arrayList.add("A");
        arrayList.add("B");
        arrayList.add("D");
        arrayList.add("E");
        arrayList.add("F");

    /*
       Get Enumeration over Java ArrayList object using,
       static Enumeration enumeration(Collection c) method of Collections class.

       This method returns the enumeration object over the specified Collection.

    */
        System.out.println(arrayList);
        //get the Enumeration object
        Enumeration e = Collections.enumeration(arrayList);

        //enumerate through the ArrayList elements
        System.out.println("Enumerating through Java ArrayList");
        while(e.hasMoreElements())
            System.out.println(e.nextElement());

    }
}

/*
Output would be
Enumerating through Java ArrayList
A
B
D
E
F
*/