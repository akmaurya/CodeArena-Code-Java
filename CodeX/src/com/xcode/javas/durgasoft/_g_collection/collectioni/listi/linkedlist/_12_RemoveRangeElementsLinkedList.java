package com.xcode.javas.durgasoft._g_collection.collectioni.listi.linkedlist;

/**
 * Created by jarvis on 5/7/17.
 */
/*
  Remove range of elements from LinkedList Java example
  This java example shows how to remove elements from Java LinkedList by
  specifying the range using sublist and clear methods.
*/

import java.util.LinkedList;

public class _12_RemoveRangeElementsLinkedList {

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
     * Removing range of elements is not directly supported. However, it
     * can be done by using subList and clear methods.
     */

        //remove elements from index 2(inclusive) to 5(exclusive)
        lList.subList(2,5).clear();

        System.out.println("Range of elements removed from LinkedList");
        System.out.println("LinkedList now contains : " + lList);
    }
}

/*
Output would be
LinkedList contains : [1, 2, 3, 4, 5]
Range of elements removed from LinkedList
LinkedList now contains : [1, 2]
*/