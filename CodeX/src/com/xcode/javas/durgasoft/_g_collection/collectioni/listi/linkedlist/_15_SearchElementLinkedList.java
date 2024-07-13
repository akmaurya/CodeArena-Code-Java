package com.xcode.javas.durgasoft._g_collection.collectioni.listi.linkedlist;

/**
 * Created by jarvis on 5/7/17.
 */
/*
  Search elements of LinkedList Java example
  This java example shows how to search element of Java LinkedList using indexOf
  and lastIndexOf methods.
*/

import java.util.LinkedList;

public class _15_SearchElementLinkedList {

    public static void main(String[] args) {

        //create LinkedList object
        LinkedList lList = new LinkedList();

        //add elements to LinkedList
        lList.add("1");
        lList.add("2");
        lList.add("3");
        lList.add("4");
        lList.add("5");
        lList.add("2");

    /*
     * To search first occurrence of an element of LinkedList, use
     * int indexOf(Object element) method.
     *
     * This method returns index of first occurrence of element if found in
     * the LinkedList. It returns -1 if element not found.
     */

        System.out.println(lList.contains("2"));
        int index = lList.indexOf("2");
        if(index != -1)
        {
            System.out.println("First occurrence of 2 in LinkedList is at index : "
                    + index);
        }
        else
        {
            System.out.println("LinkedList does not contain 2");
        }

    /*
     * To search last occurrence of an element of LinkedList, use
     * int lastIndexOf(Object element) method.
     *
     * This method returns index of last occurrence of element if found in
     * the LinkedList. It returns -1 if element not found.
     */

        index = lList.lastIndexOf("2");
        if(index != -1)
        {
            System.out.println("Last occurrence of 2 in LinkedList is at index : "
                    + index);
        }
        else
        {
            System.out.println("LinkedList does not contain 2");
        }

    }
}