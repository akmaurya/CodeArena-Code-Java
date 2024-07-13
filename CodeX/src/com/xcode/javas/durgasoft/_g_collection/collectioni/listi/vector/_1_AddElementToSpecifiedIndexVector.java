package com.xcode.javas.durgasoft._g_collection.collectioni.listi.vector;

/**
 * Created by jarvis on 5/7/17.
 */
/*
  Add an element to specified index of Java Vector Example
  This Java Example shows how to add an element at specified index of java
  Vector object using add method.
*/

import java.util.Vector;

public class _1_AddElementToSpecifiedIndexVector {

    public static void main(String[] args) {
        //create an Vector object
        Vector v = new Vector();

        //Add elements to Vector
        v.add("1");
        v.add("2");
        v.add("3");

    /*
      To add an element at the specified index of Vector use
      void add(int index, Object obj) method.
      This method inserts the specified element at the specified index in the
      Vector.
    */
        System.out.println(v);
        v.add(1,"INSERTED ELEMENT");
        System.out.println(v);

    /*
      Please note that add method DOES NOT overwrites the element previously
      at the specified index in the Vector. It shifts the elements to right side
      and increasing the Vector size by 1.
    */

        System.out.println("Vector contains...");
        //display elements of Vector
        for(int index=0; index < v.size(); index++)
            System.out.println(v.get(index));

    /*
       To append an element at the end of Vector use
       boolean add(Object o) method.
       It returns true as a general behavior of the Collection.add method and
       appends the specified element at the end of Vector.
    */
    }
}

/*
Vector contains...
1
INSERTED ELEMENT
2
3
*/