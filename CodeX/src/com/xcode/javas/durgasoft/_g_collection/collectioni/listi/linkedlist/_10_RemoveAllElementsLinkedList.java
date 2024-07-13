package com.xcode.javas.durgasoft._g_collection.collectioni.listi.linkedlist;

/**
 * Created by jarvis on 5/7/17.
 */
/*
  Remove all elements or clear LinkedList Java example
  This java example shows how to all elements or clear or empty Java LinkedList
  using clear or removeAll method.
*/

import java.util.LinkedList;

public class _10_RemoveAllElementsLinkedList {

    public static void main(String[] args) {

        //create LinkedList object
        LinkedList lList = new LinkedList();

        //add elements to LinkedList
        lList.add("1");
        lList.add("2");
        lList.add("3");
        lList.add("4");
        lList.add("5");

        System.out.println("LinkedList contains : " + lList);

    /*
     * To remove all elements of Java LinkedList, use
     * void clear() method.
     *
     * This method remove all elements from LinkedList object.
     */

        lList.clear();
        System.out.println("LinkedList now contains : " + lList);

     /*
      * Please note that removeAll method can also be used to remove
      * all elements from LinkedList.
      */
    }
}

/*
Output would be

LinkedList contains : [1, 2, 3, 4, 5]
LinkedList now contains : []
*/