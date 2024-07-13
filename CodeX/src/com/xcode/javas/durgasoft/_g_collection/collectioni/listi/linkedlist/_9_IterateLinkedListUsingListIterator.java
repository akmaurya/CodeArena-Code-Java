package com.xcode.javas.durgasoft._g_collection.collectioni.listi.linkedlist;

/**
 * Created by jarvis on 5/7/17.
 */
/*
  Iterate through elements of Java LinkedList using ListIterator example
  This java example shows how to iterate through elements of Java LinkedList
  using ListIterator's next, hasNext, hasPrevious and previous methods.
*/

import java.util.ListIterator;
import java.util.LinkedList;

public class _9_IterateLinkedListUsingListIterator {

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
     * To get an ListIterator object of LinkedList, use
     * ListIterator listIterator() method.
     */

        ListIterator itr = lList.listIterator();

        System.out.println("Iterating through elements of Java LinkedList using ListIterator in forward direction...");
        while(itr.hasNext())
        {
            System.out.println(itr.next());
        }

        System.out.println("Iterating through elements of Java LinkedList using ListIterator in reverse direction...");
        while(itr.hasPrevious())
            System.out.println(itr.previous());

        System.out.println(lList);
    }
}

/*
Output would be
Iterating through elements of Java LinkedList using ListIterator
in forward direction...
1
2
3
4
5
Iterating through elements of Java LinkedList using ListIterator
in reverse direction...
5
4
3
2
1
*/