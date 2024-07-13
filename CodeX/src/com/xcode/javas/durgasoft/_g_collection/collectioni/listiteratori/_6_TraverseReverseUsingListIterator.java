package com.xcode.javas.durgasoft._g_collection.collectioni.listiteratori;

/**
 * Created by jarvis on 5/7/17.
 */
/*
  Traverse through ArrayList in reverse direction using Java ListIterator Example
  This Java Example shows how to iterate through an ArrayList object in reverse
  direction using Java ListIterator's previous and hasPrevious methods .
*/

import java.util.ListIterator;
import java.util.ArrayList;

public class _6_TraverseReverseUsingListIterator {

    public static void main(String[] args) {
        //create an object of ArrayList
        ArrayList aList = new ArrayList();

        //Add elements to ArrayList object
        aList.add("1");
        aList.add("2");
        aList.add("3");
        aList.add("4");
        aList.add("5");

        //Get an object of ListIterator using listIterator() method
        ListIterator listIterator = aList.listIterator();

        //Traverse in forward direction
        System.out.println("Traversing ArrayList in forward direction using ListIterator");
        while(listIterator.hasNext())
            System.out.println(listIterator.next());

    /*
      Traverse the ArrayList in reverse direction using hasPrevious and previous
      methods of ListIterator. hasPrevious method returns true if
      ListIterator has more elements to traverse in reverse direction.
      Previous method returns previous element in the list.
    */
        System.out.println("Traversing ArrayList in reverse direction using ListIterator");
        while(listIterator.hasPrevious())
            System.out.println(listIterator.previous());

    }
}

/*
Traversing ArrayList in forward direction using ListIterator
1
2
3
4
5
Traversing ArrayList in reverse direction using ListIterator
5
4
3
2
1
*/