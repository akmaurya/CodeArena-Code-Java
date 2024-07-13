package com.xcode.javas.durgasoft._g_collection.collectioni.listi.vector;

/**
 * Created by jarvis on 5/7/17.
 */
/*
  Iterate through elements Java Vector using Iterator Example
  This Java Example shows how to iterate through the elements of java
  Vector object using Iterator.
*/

import java.util.Vector;
import java.util.Iterator;

public class _7_IterateThroughVectorUsingIterator {

    public static void main(String[] args) {

        //create Vector object
        Vector v = new Vector();

        //Add elements to Vector
        v.add("1");
        v.add("2");
        v.add("3");
        v.add("4");
        v.add("5");

        //get an Iterator object for Vector using iterator() method.
        Iterator itr = v.iterator();

        System.out.println(v);
        //use hasNext() and next() methods of Iterator to iterate through the elements
        System.out.println("Iterating through Vector elements...");
        while(itr.hasNext())
            System.out.println(itr.next());

    }
}

/*
Output would be
Iterating through Vector elements...
1
2
3
4
5
*/