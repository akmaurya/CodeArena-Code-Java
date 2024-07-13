package com.xcode.javas.durgasoft._g_collection.collectioni.listi.linkedlist;

/**
 * Created by jarvis on 5/7/17.
 */
/*
  Get elements from LinkedList Java example
  This java example shows how to get element at specified index from Java LinkedList
  using get method.
*/

import java.util.LinkedList;

public class _5_GetElementsLinkedList {

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
     * To get element at specified index from Java LinkedList, use
     * Object get(int index) method.
     *
     * This method returns element at sepcified index from LinkedList.
     */

        System.out.println("LinkedList contains : ");
        for(int i=0; i< lList.size(); i++)
        {
            System.out.println(lList.get(i));
        }

        System.out.println(lList);
    }
}

/*
Output would be
LinkedList contains :
1
2
3
4
5
*/