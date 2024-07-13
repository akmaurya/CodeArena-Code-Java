package com.xcode.javas.durgasoft._g_collection.collectioni.listi.vector;

/**
 * Created by jarvis on 5/7/17.
 */
/*
  Set size of Java Vector Example
  This Java Example shows how to set the size of Java Vector object using
  setSize method. Size of the Vector can be changed anytime after creating it using
  this method.
*/

import java.util.Vector;

public class _15_SetSizeOfJavaVector {

    public static void main(String[] args) {
        //create a Vector object
        Vector v = new Vector();

        //Add elements to Vector
        v.add("1");
        v.add("2");
        v.add("3");
        v.add("4");
        v.add("5");

    /*
      To set the size of Vector use
      void setSize(int newSize) method.
      Please note that if the newSize is less than the current size of the Vector
      elements at and after newSize index will be discarded, and if the newSize is
      grater than the current size of Vector, null values are added at the end of
      the Vector.
    */
        System.out.println(v);
        //set size of Vector to 3. The Last 2 elements would be discarded.
        v.setSize(3);

        //display elements of the Vector
        System.out.println("Vector elements after setting size to 3");
        System.out.println(v);
        for(int index=0; index < v.size(); index++)
            System.out.println(v.get(index));

        //set size of Vector to 5. null values would be inserted in the Vector.
        v.setSize(5);

        //display elements of the Vector
        System.out.println("Vector elements after setting size to 5");
        for(int index=0; index < v.size(); index++)
            System.out.println(v.get(index));

    }
}
/*
Output would be
Vector elements after setting size to 3
1
2
3
Vector elements after setting size to 5
1
2
3
null
null
*/