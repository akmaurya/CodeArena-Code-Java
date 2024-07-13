package com.xcode.javas.durgasoft._g_collection.collectioni.listi.vector;

/**
 * Created by jarvis on 5/7/17.
 */
/*
  Get Size of Java Vector and loop through the elements Example
  This Java Example shows how to get size or number of elements currently
  stored in Vector. It also shows how to loop through the element of it.
*/

import java.util.Vector;

public class _4_GetSizeOfVector     {

    public static void main(String[] args) {
        //create a Vector object
        Vector v = new Vector();

        //Add elements to Vector using
        v.add("1");
        v.add("2");
        v.add("3");

        //To get size of Java Vector use int size() method
        System.out.println(v);

        int totalElements = v.size();
        System.out.println("Size of vector = "+totalElements);

        System.out.println("Vector contains...");
        //loop through it
        for(int index=0; index < totalElements; index++)
            System.out.println(v.get(index));

    }
}

/*
Output would be
Vector contains...
1
2
3
*/