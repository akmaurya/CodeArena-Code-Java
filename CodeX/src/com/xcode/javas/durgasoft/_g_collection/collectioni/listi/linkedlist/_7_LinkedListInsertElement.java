package com.xcode.javas.durgasoft._g_collection.collectioni.listi.linkedlist;

/**
 * Created by jarvis on 5/7/17.
 */
/*
  Insert an Element into LinkedList Java example
  This java example shows how to insert an element to specified index using
  add method of Java LinkedList class.
*/

import java.util.LinkedList;

public class _7_LinkedListInsertElement {

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
     * To insert an element into LinkedList object, use
     * void add(int index , Object element) method.
     *
     * It inserts specified element at specified index in the LinkedList by
     * shifting current elements and subsequent elements to the right.
     */

        lList.add(2, "2.5");
        System.out.println("After inserting 2.5, LinkedList contains : " + lList);


    }
}

/*
Output would be

LinkedList contains : [1, 2, 3, 4, 5]
After inserting 2.5, LinkedList contains : [1, 2, 2.5, 3, 4, 5]
*/
