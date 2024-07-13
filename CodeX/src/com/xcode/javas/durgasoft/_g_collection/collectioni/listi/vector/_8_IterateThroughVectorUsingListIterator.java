package com.xcode.javas.durgasoft._g_collection.collectioni.listi.vector;

/**
 * Created by jarvis on 5/7/17.
 */
/*
  Iterate through elements Java Vector using ListIterator Example
  This Java Example shows how to iterate through the elements of java
  Vector object in forward and backward direction using ListIterator.
*/

import java.util.Vector;
import java.util.ListIterator;

public class _8_IterateThroughVectorUsingListIterator {

    public static void main(String[] args) {

        //create Vector object
        Vector v = new Vector();

        //Add elements to Vector
        v.add("1");
        v.add("2");
        v.add("3");
        v.add("4");
        v.add("5");

    /*
      Get a ListIterator object for Vector using
      listIterator() method.
    */
        ListIterator itr = v.listIterator();

    /*
      Use hasNext() and next() methods of ListIterator to iterate through
      the elements in forward direction.
    */
        System.out.println(v);
        System.out.println("Iterating through Vector elements in forward direction...");
        while(itr.hasNext())
            System.out.println(itr.next());

    /*
      Use hasPrevious() and previous() methods of ListIterator to iterate through
      the elements in backward direction.
    */
        System.out.println("Iterating through Vector elements in backward direction...");
        while(itr.hasPrevious())
            System.out.println(itr.previous());

    }
}

/*
Output would be
Iterating through Vector elements in forward direction...
1
2
3
4
5
Iterating through Vector elements in backward direction...
5
4
3
2
1
*/