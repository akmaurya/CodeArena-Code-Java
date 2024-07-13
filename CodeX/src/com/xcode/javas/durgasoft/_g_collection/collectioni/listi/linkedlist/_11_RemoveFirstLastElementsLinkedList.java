package com.xcode.javas.durgasoft._g_collection.collectioni.listi.linkedlist;

/**
 * Created by jarvis on 5/7/17.
 */
/*
  Remove first and last elements of LinkedList Java example
  This java example shows how to remove first and last elements of Java LinkedList
  object using removeFirst and removeLast methods.
*/

import java.util.LinkedList;

public class _11_RemoveFirstLastElementsLinkedList {

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
     * To remove first element of Java LinkedList, use
     * Object removeFirst() method.
     *
     * This method removes first element of LinkedList and shifts the subsequent
     * elements to the left. It returns the element previously at the first index
     * of the LinkedList.
     */

        Object object = lList.removeFirst();
        System.out.println(object + " has been removed from the first index of LinkedList");
                System.out.println("LinkedList now contains : " + lList);

     /*
      * To remove last element of Java LinkedList, use
      * Object removeLast() method.
      *
      * This method removes last element of LinkedList. It returns the element
      * previously at the last index of the LinkedList.
      */

        object = lList.removeLast();
        System.out.println(object + " has been removed from the last index of LinkedList");
                System.out.println("LinkedList now contains : " + lList);

    }
}

/*
Output would be

LinkedList contains : [1, 2, 3, 4, 5]
1 has been removed from the first index of LinkedList
LinkedList now contains : [2, 3, 4, 5]
5 has been removed from the last index of LinkedList
LinkedList now contains : [2, 3, 4]
*/