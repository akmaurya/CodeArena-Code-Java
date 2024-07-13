package com.xcode.javas.durgasoft._g_collection.collectioni.listi.vector;

/**
 * Created by jarvis on 5/7/17.
 */
/*
  Search an element of Java Vector from specific index Example
  This Java Example shows how to search an element of java Vector from specific
  index using indexOf and lastIndexOf methods.
*/

import java.util.Vector;

public class _14_SearchAnElementFromSpecificIndexVector {

    public static void main(String[] args) {

        //create a Vector object
        Vector v = new Vector();

        //Add elements to Vector
        v.add("1");
        v.add("2");
        v.add("3");
        v.add("4");
        v.add("5");
        v.add("1");
        v.add("2");

    /*
      To search an index of specified element in Vector from specified index use
      int indexOf(Object element, int startIndex) method.
      This method returns the index of the first occurence of the specified
      element after startIndex in Vector. It returns -1 if not found.
    */

        System.out.println(v);
        int index = v.indexOf("1",4);
        if(index == -1)
            System.out.println("Vector does not contain 1 after index # 4");
        else
            System.out.println("Vector contains 1 after index # 4 at index #" + index);

    /*
      To get last index of specified element after specified index in Vector use
      int lastIndexOf(Object element, int startIndex) method.
      This method returns index of the last occurrence of the
      specified element after startIndex in Vector. It returns -1 if not found.
    */


        System.out.println("Last index of 1 = "+v.lastIndexOf("1"));
        int lastIndex = v.lastIndexOf("1" , 4);
        if(lastIndex == -1)
            System.out.println("Vector does not contain 2 after index # 5");
        else
            System.out.println("Last occurrence of 2  after index # 5 in Vector is at index #" + lastIndex);

    }
}
/*
Output would be
Vector contains 1 after index # 4 at index #5
Last occurrence of 2  after index # 5 in Vector is at index #1
*/