package com.xcode.javas.durgasoft._g_collection.collectioni.listiteratori;

/**
 * Created by jarvis on 5/7/17.
 */
/*
  Get Previous and next index using Java ListIterator Example
  This Java Example shows how to get previous and next index while traversing through
  elements of ArrayList using Java ListIterator.
*/

import java.util.ListIterator;
import java.util.ArrayList;

public class _2_GetPreviousAndNextIndexListIterator {

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
      Use nextIndex and previousIndex methods of ListIterator to get next and
      previous index from the current position in the list.
    */
        System.out.println(aList);
        System.out.println("Previous Index is : " + listIterator.previousIndex());
        System.out.println("Next Index is : " + listIterator.nextIndex());

        //advance current position by one using next method
        listIterator.next();

        System.out.println("After increasing current position by one element : ");
        System.out.println("Previous Index is : " + listIterator.previousIndex());
        System.out.println("Next Index is : " + listIterator.nextIndex());


    }
}

/*
Previous Index is : -1
Next Index is : 0
After increasing current position by one element :
Previous Index is : 0
Next Index is : 1
*/



