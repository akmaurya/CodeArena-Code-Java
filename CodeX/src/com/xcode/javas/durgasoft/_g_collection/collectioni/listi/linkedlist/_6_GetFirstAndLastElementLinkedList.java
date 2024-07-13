package com.xcode.javas.durgasoft._g_collection.collectioni.listi.linkedlist;

/**
 * Created by jarvis on 5/7/17.
 */
/*
  Get first and last elements from LinkedList Java example
  This java example shows how to get first and last element from Java LinkedList
  using getFirst and getLast methods.
*/

import java.util.LinkedList;

public class _6_GetFirstAndLastElementLinkedList {

    public static void main(String[] args) {

        //create LinkedList object
        LinkedList lList = new LinkedList();

        //add elements to LinkedList
        lList.add("1");
        lList.add("2");
        lList.add("3");
        lList.add("4");
        lList.add("5");

    /*
     * To get first element from Java LinkedList, use
     * Object getFirst() method.
     *
     * This method returns first element stored in LinkedList.
     */

        System.out.println(lList);
        System.out.println("First element of LinkedList is : " + lList.getFirst());

    /*
     * To get last element from Java LinkedList, use
     * Object getLast() method.
     *
     * This method returns last element stored in LinkedList.
     */

        System.out.println("Last element of LinkedList is : " + lList.getLast());


    }
}

/*
Output would be
First element of LinkedList is : 1
Last element of LinkedList is : 5
*/