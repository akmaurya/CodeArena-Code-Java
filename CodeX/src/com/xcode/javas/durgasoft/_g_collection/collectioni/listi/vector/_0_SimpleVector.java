package com.xcode.javas.durgasoft._g_collection.collectioni.listi.vector;

/**
 * Created by jarvis on 5/7/17.
 */
/*
  Simple Java Vector Example
  This Java Example shows how to create an object of Java Vector. It also
  shows how to add elements to Vector and how get the same from Vector.
*/

import java.util.Vector;

public class _0_SimpleVector {

    public static void main(String[] args) {

        //create a Vector object
        Vector v = new Vector();

    /*
       Add elements to Vector using
       boolean add(Object o) method. It returns true as a general behavior
       of Collection.add method. The specified object is appended at the end
       of the Vector.
    */
        v.add("1");
        v.add("2");
        v.add("3");

    /*
      Use get method of Java Vector class to display elements of Vector.
      Object get(int index) returns an element at the specified index in
      the Vector
    */
        System.out.println("Getting elements of Vector");
        System.out.println(v.get(0));
        System.out.println(v.get(1));
        System.out.println(v.get(2));

        System.out.println(v);
    }
}

/*
Output would be
Getting elements of Vector
1
2
3
*/