package com.xcode.javas.durgasoft._g_collection.collectioni.listi.vector;

/**
 * Created by jarvis on 5/7/17.
 */
/*
  Replace an element at specified index of Java Vector Example
  This Java Example shows how to replace an element at specified index of java
  Vector object using set method.
*/

import java.util.Vector;

public class _12_ReplaceElementAtSpecifiedIndexVector {

    public static void main(String[] args) {
        //create a Vector object
        Vector v = new Vector();

        //Add elements to Vector
        v.add("1");
        v.add("2");
        v.add("3");

    /*
      To replace an element at the specified index of Vector use
      Object set(int index, Object obj) method.
      This method replaces the specified element at the specified index in the
      Vector and returns the element previously at the specified position.
    */
        System.out.println(v);
        v.set(1,"REPLACED ELEMENT");

        System.out.println("Vector contains...");
        System.out.println(v);
        //display elements of Vector
        for(int index=0; index < v.size(); index++)
            System.out.println(v.get(index));

    }
}

/*
Output would be
Vector contains...
1
REPLACED ELEMENT
3
*/