package com.xcode.javas.durgasoft._g_collection.collectioni.listi.linkedlist;

/**
 * Created by jarvis on 5/7/17.
 */
/*
  Replace an Element of LinkedList Java example
  This java example shows how to replace a LinkedList element at specified index
  using set method of Java LinkedList class.
*/

import java.util.LinkedList;

public class _14_LinkedListReplaceElement {

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
     * To replace an element of LinkedList at specified index, use
     * Object set(int index, Object element) method.
     *
     * It replaces specified element at specified index in the LinkedList and
     * returns the element previously at the specified index.
     */

        lList.set(3, "Replaced");
        System.out.println("After replacing 4, LinkedList contains : " + lList);


    }
}

/*
Output would be
LinkedList contains : [1, 2, 3, 4, 5]
After replacing 4, LinkedList contains : [1, 2, 3, Replaced, 5]
*/