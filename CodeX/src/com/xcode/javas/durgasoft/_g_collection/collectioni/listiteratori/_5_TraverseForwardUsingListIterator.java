package com.xcode.javas.durgasoft._g_collection.collectioni.listiteratori;

/**
 * Created by jarvis on 5/7/17.
 */
/*
  Traverse through ArrayList in forward direction using Java ListIterator Example
  This Java Example shows how to iterate through an ArrayList object
  in forward direction using Java ListIterator's next and hasNext methods .
*/

import java.util.ListIterator;
import java.util.ArrayList;

public class _5_TraverseForwardUsingListIterator {

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

    /*
       Traverse the ArrayList in forward direction using hasNext and next methods
       of ListIterator. hasNext method returns true if ListIterator has more
       elements to traverse in forward direction. Next method returns next element
       in the list.
    */
        System.out.println("Traversing ArrayList in forward direction using ListIterator");
        while(listIterator.hasNext())
            System.out.println(listIterator.next());
    }
}

/*
Traversing ArrayList in forward direction using ListIterator
1
2
3
4
5
*/