package com.xcode.javas.durgasoft._g_collection.collectioni.listi.linkedlist;

/**
 * Created by jarvis on 5/7/17.
 */
/*
  Iterate through elements of Java LinkedList using Iterator example
  This java example shows how to iterate through elements of Java LinkedList
  using Iterator's hasNext and next methods.
*/

import java.util.Iterator;
import java.util.LinkedList;


public class _8_IterateThroughLinkedListUsingIterator {

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
     * To get an Iterator object of LinkedList, use
     * Iterator iterator() method.
     */

        System.out.println(lList);
        Iterator itr = lList.iterator();

        System.out.println("Iterating through elements of Java LinkedList...");
        System.out.println("LinkedList contains : ");
        while(itr.hasNext())
        {
            System.out.println(itr.next());
        }

    }
}
/*
Output would be
Iterating through elements of Java LinkedList...
LinkedList contains :
1
2
3
4
5
*/