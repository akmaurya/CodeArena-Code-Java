package com.xcode.javas.durgasoft._g_collection.collections;

/**
 * Created by jarvis on 7/7/17.
 */
/*
  Create List containing n Copies of Specified Object Example
  This java example shows how to create a list consisting n copies of specified
  copies using nCopies method of Collections class.
*/

import java.util.Collections;
import java.util.List;
import java.util.Iterator;

public class _3_CreateListOfNCopies {

    public static void main(String[] args) {

    /*
      To create a List containing n copies of specified Object use,
      static List nCopies(int n, Object obj) method of Java Collections class.

      This method returns immutable List containing n copies of the
      specified Object.
    */

        List list = Collections.nCopies(5,"A");

        //iterate through newly created list
        System.out.println("List contains, ");
        System.out.println(list);
        Iterator itr = list.iterator();

        while(itr.hasNext())
            System.out.println(itr.next());

    }
}

/*
Output would be
List contains,
A
A
A
A
A
*/