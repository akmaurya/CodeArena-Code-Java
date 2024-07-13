package com.xcode.javas.durgasoft._g_collection.collectioni.listi.linkedlist;

/**
 * Created by jarvis on 5/7/17.
 */
/*
  Simple Java LinkedList example
  This java example shows how to use LinkedList class to create LinkedList
  implementation in Java. This example also shows how to add elements to
  LinkedList object using add method.
*/

import java.util.LinkedList;

public class _0_SimpleJavaLinkedList {

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
     * Please note that primitive values can not be added into LinkedList
     * directly. They must be converted to their corrosponding wrapper class.
     */

        System.out.println("LinkedList contains : " + lList);

    }
}


/*
Output would be
LinkedList contains : [1, 2, 3, 4, 5]
*/