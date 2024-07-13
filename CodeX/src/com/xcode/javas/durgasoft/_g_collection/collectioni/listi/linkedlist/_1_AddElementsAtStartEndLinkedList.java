package com.xcode.javas.durgasoft._g_collection.collectioni.listi.linkedlist;

/**
 * Created by jarvis on 5/7/17.
 */
/*
  Add elements at beginning and end of LinkedList Java example
  This java example shows how to add an element at beginning or at end of
  java LinkedList object using addFirst and addLast methods.
*/

import java.util.LinkedList;

public class _1_AddElementsAtStartEndLinkedList {

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
     * To add an element at the beginning of the LinkedList, use
     * void addFirst(Object obj) method.
     *
     * This method inserts object at the beginning of the LinkedList.
     */

        lList.addFirst("0");
        System.out.println("After inserting 0 at beginning, LinkedList contains :"
                + lList);

    /*
     * To append an element at end of the LinkedList, use
     * void addLast(Object obj) method.
     *
     * This method append specified element at the end of the LinkedList.
     */

        lList.addLast("6");
        System.out.println("After appending 0 at end, LinkedList contains :" + lList);

    }
}

/*
Output would be

LinkedList contains : [1, 2, 3, 4, 5]
After inserting 0 at beginning, LinkedList contains :[0, 1, 2, 3, 4, 5]
After appending 0 at end, LinkedList contains :[0, 1, 2, 3, 4, 5, 6]
*/