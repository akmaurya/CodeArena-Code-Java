package com.xcode.javas.durgasoft._g_collection.collectioni.listiteratori;

/**
 * Created by jarvis on 5/7/17.
 */
/*
  Add or insert an element to ArrayList using Java ListIterator Example
  This Java Example shows how to add or insert an element while traversing through
  elements of ArrayList using Java ListIterator.
*/

import java.util.ListIterator;
import java.util.ArrayList;

public class _1_AddAnElementUsingListIterator {

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
        System.out.println(aList);
        ListIterator listIterator = aList.listIterator();

    /*
      Use void add(Object o) method of ListIterator to add or insert an element
      to List. It adds an element just before the element that would have
      been returned by next method call and after the element that would have
      returned by previous call.
    */

        listIterator.next();

        //Add an element
        listIterator.add("Added Element");
    /*
      add method can throw UnsupportedOperationException if add operation
      is not supported by this ListIterator.

      Please also note that, sebsequent call to previous method after adding
      an element, would return the newly added element.
    */


        System.out.println("After inserting element, ArrayList contains");
        System.out.println(aList);
        for(int intIndex = 0; intIndex < aList.size(); intIndex++)
            System.out.println(aList.get(intIndex));


    }
}

/*
Output would be
After inserting element, ArrayList contains
1
Added Element
2
3
4
5
*/