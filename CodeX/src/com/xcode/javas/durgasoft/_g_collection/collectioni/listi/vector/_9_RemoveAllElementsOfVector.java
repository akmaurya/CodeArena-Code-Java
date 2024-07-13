package com.xcode.javas.durgasoft._g_collection.collectioni.listi.vector;

/**
 * Created by jarvis on 5/7/17.
 */
/*
  Remove all elements from Java Vector Example
  This Java Example shows how to remove all elements from java Vector object
  using clear and removeAllElements method.
*/

import java.util.Vector;

public class _9_RemoveAllElementsOfVector {

    public static void main(String[] args) {
        //create a Vector object
        Vector v = new Vector();

        //Add elements to Vector
        v.add("1");
        v.add("2");
        v.add("3");

        System.out.println(v);
        System.out.println("Size of Vector before removing elements : " + v.size());
    /*
      To remove all elements from the Vector use
      void clear() method.
    */
        v.clear();
        //OR v.removeAllElements();
        System.out.println("Size of Vector after removing elements : " + v.size());
        System.out.println(v);
    /*
       Please note that removeAllElements method is also identical to clear
       method and can be used to remove all elements from the Vector.
    */
    }
}
/*
Output would be
Size of Vector before removing elements : 3
Size of Vector after removing elements : 0
*/