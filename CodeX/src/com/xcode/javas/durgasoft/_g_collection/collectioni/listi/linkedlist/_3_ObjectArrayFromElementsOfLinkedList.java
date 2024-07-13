package com.xcode.javas.durgasoft._g_collection.collectioni.listi.linkedlist;

/**
 * Created by jarvis on 5/7/17.
 */
/*
  Create an object array from elements of LinkedList Java example
  This java example shows how to create an Object array from elements of Java
  LinkedList using toArray method.
*/

import java.util.LinkedList;

public class _3_ObjectArrayFromElementsOfLinkedList {

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
     * To create an Object array from elements of Java LinkedList, use
     * Object[] toArray() method.
     *
     * This method returns an array of Objects containing the elements
     * of Java LinkedList in correct order.
     */

        System.out.println(lList);
        Object[] objArray = lList.toArray();

        System.out.println("Object array created from Java LinkedList.");
        System.out.println("Object array contains : ");

        for(int i=0; i<objArray.length ; i++)
        {
            System.out.println(objArray[i]);
        }
    }
}

/*
Output would be

Object array created from Java LinkedList.
Object array contains :
1
2
3
4
5
*/