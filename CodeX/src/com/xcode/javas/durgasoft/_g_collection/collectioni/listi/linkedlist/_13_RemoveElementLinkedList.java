package com.xcode.javas.durgasoft._g_collection.collectioni.listi.linkedlist;

/**
 * Created by jarvis on 5/7/17.
 */
/*
  Remove element from LinkedList Java example
  This java example shows how to remove a particular element from Java LinkedList.
  It also shows how to remove an element at specified index from LinkedList.
*/

import java.util.LinkedList;

public class _13_RemoveElementLinkedList {

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
     * To remove a specified element from Java LinkedList, use
     * boolean remove(Object obj) method.
     *
     * This method removes the first occurrence of the specified element from
     * Java LinkedList and returns true if LinkedList contained the specified
     * element.
     *
     * If LinkedList did not contain the specified element, it remains unchanged.
     */

        boolean isRemoved = lList.remove("2");
        System.out.println("Is 2 removed from LinkedList ? :" + isRemoved);
        System.out.println("LinkedList now contains : " + lList);

     /*
      * To remove an element at specified index of LinkedList, use
      * Object remove(int index) method.
      *
      * This method removes an element from specified index and shifts subsequent
      * elements to the left. It returns an element previously at the specified
      * index.
      */

        Object obj = lList.remove(2);
        System.out.println(obj + " has been removed from LinkedList");
        System.out.println("LinkedList now contains : " + lList);
    }
}

/*
Output would be

LinkedList contains : [1, 2, 3, 4, 5]
Is 2 removed from LinkedList ? :true
LinkedList now contains : [1, 3, 4, 5]
4 has been removed from LinkedList
LinkedList now contains : [1, 3, 5]
*/