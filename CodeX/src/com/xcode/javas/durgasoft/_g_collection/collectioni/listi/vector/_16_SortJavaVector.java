package com.xcode.javas.durgasoft._g_collection.collectioni.listi.vector;

/**
 * Created by jarvis on 5/7/17.
 */
/*
  Sort elements of Java Vector Example
  This Java Example shows how to sort the elements of java Vector object using
  Collections.sort method.
*/

import java.util.Vector;
import java.util.Collections;

public class _16_SortJavaVector {

    public static void main(String[] args) {

        //create Vector object
        Vector v = new Vector();

        //Add elements to Vector
        v.add("1");
        v.add("3");
        v.add("5");
        v.add("2");
        v.add("4");

    /*
      To sort a Vector object, use Collection.sort method. This is a
      static method. It sorts an Vector object's elements into ascending order.
    */
        System.out.println(v);
        Collections.sort(v);
        //display elements of Vector
        System.out.println("Vector elements after sorting in ascending order : ");
        System.out.println(v);
        for(int i=0; i<v.size(); i++)
            System.out.println(v.get(i));

    }
}

/*
Output would be
Vector elements after sorting in ascending order :
1
2
3
4
5
*/