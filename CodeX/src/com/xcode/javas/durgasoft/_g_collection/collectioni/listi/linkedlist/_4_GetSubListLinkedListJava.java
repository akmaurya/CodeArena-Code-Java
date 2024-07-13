package com.xcode.javas.durgasoft._g_collection.collectioni.listi.linkedlist;

/**
 * Created by jarvis on 5/7/17.
 */
/*
  Get SubList from LinkedList Java example
  This java example shows how to get a sublist from Java LinkedList using
  subList method.
*/

import java.util.LinkedList;
import java.util.List;

public class _4_GetSubListLinkedListJava {

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
     * To get a sublist from Java LinkedList, use
     * List subList(int start, int end) method.
     *
     * This method returns portion of list containing element from start index
     * inclusive to end index exclusive.
     */

        List lst = lList.subList(1,4);
        System.out.println("Sublist contains : " + lst);

    /*
     * Please note that sublist is backed by the original list, so any changes
     * made to sublist will also be reflected back to original LinkedList
     */

        //remove element from sublist
        lst.remove(2);
        System.out.println("Sublist now contains : " + lst);
        System.out.println("Original LinkedList now contains : " + lList);
    }
}

/*
Output would be
LinkedList contains : [1, 2, 3, 4, 5]
Sublist contains : [2, 3, 4]
Sublist now contains : [2, 3]
Original LinkedList now contains : [1, 2, 3, 5]
*/