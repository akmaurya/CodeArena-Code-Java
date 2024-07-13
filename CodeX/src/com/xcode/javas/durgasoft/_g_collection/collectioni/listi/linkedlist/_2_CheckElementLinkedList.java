package com.xcode.javas.durgasoft._g_collection.collectioni.listi.linkedlist;

/**
 * Created by jarvis on 5/7/17.
 */
/*
  Check if a particular element exists in LinkedList Java example
  This java example shows how to check if a particular element exists in Java
  LinkedList object using contains method.
*/

import java.util.LinkedList;

public class _2_CheckElementLinkedList {

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
     * To check if a particular element exists in a LinkedList, use
     * boolean contains(Object obj) method.
     *
     * This method returns true if LinkedList contains a particular element,
     * false otherwise.
     */

        boolean blnElement = lList.contains("4");



        if(blnElement)
        {
            System.out.println("LinkedList contains 4 at position = "+lList.indexOf("4"));
        }
        else
        {
            System.out.println("LinkedList does not contain 4");
        }
    }
}

/*
Output would be
LinkedList contains 4
*/