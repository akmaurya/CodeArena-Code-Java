package com.xcode.javas.durgasoft._g_collection.collectioni.listiteratori;

/**
 * Created by jarvis on 5/7/17.
 */
/*
  Remove an element from ArrayList using Java ListIterator Example
  This Java Example shows how to remove an element while traversing through
  elements of ArrayList using Java ListIterator.
*/

import java.util.ListIterator;
import java.util.ArrayList;

public class _3_RemoveAnElementUsingListIterator {

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
      Use void remove() method of ListIterator to remove an element from List.
      It removes the last element returned by next or previous methods.
      Please note that, remove method removes the element from underlying list.
    */

        System.out.println(aList);
        listIterator.next();
        listIterator.next();

        //remove element returned by last next method
        listIterator.remove();
    /*
      Remove method can throw UnsupportedOperationException if remove operation
      is not supported by this ListIterator.

      In addition to that, it can also throw IllegalStateException if remove is
      called before call of neither previous nor next methods or after the last
      call of next or previous methods.
    */


        System.out.println("After removing 2, ArrayList contains");
        System.out.println(aList);
        for(int intIndex = 0; intIndex < aList.size(); intIndex++)
            System.out.println(aList.get(intIndex));


    }
}

/*
Output would be
After removing 2, ArrayList contains
1
3
4
5
*/