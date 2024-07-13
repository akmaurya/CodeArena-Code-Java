package com.xcode.javas.durgasoft._g_collection.collectioni.listiteratori;

/**
 * Created by jarvis on 5/7/17.
 */
/*
  Replace an element from ArrayList using Java ListIterator Example
  This Java Example shows how to replace an element while traversing through
  elements of ArrayList using Java ListIterator.
*/

import java.util.ListIterator;
import java.util.ArrayList;

public class _4_ReplaceAnElementUsingListIterator {

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
      Use void set(Object o) method of ListIterator to replace an element from List.
      It replaces the last element returned by next or previous methods.
      Please note that, set method replaces the element from underlying list.
    */
        System.out.println(aList);

        listIterator.next();

        //replace element returned by last next method i.e. 1
        listIterator.set("100");
    /*
      Set method can throw UnsupportedOperationException if set operation
      is not supported by this ListIterator.

      In addition to that, it can also throw IllegalStateException if set is
      called before call of neither previous nor next methods or after the last
      call of next or previous methods.

      Please also note that, set method can only be called if neither add
      or remove called after last call of next of previous methods.
    */


        System.out.println("After replacing 1 with 100, ArrayList contains");
        System.out.println(aList);
        for(int intIndex = 0; intIndex < aList.size(); intIndex++)
            System.out.println(aList.get(intIndex));


    }
}

/*
Output would be
After replacing 1 with 100, ArrayList contains
100
2
3
4
5
*/