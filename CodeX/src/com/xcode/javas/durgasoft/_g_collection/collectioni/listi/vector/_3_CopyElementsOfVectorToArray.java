package com.xcode.javas.durgasoft._g_collection.collectioni.listi.vector;

/**
 * Created by jarvis on 5/7/17.
 */
/*
  Copy all elements of Java Vector to an Object Array Example
  This Java Example shows how to copy all elements of Java Vector object to an
  array using copyInTo method.
*/

import java.util.Vector;

public class _3_CopyElementsOfVectorToArray {

    public static void main(String[] args) {
        //create a Vector object
        Vector v = new Vector();

        //Add elements to Vector
        v.add("1");
        v.add("2");
        v.add("3");
        v.add("4");
        v.add("5");

        //declare an array to hold elements of Vector
        Object[] objArray = new Object[5];

    /*
      To copy all elements of java vector object into array use
      void copyInTo(Ojbect[] obj) method. Here obj is an array into which
      elements will get copied.
      Please note that the array should be big enough to hold all elements of
      java vector object. If not, ArrayIndexOutOfBoundException would be thrown.
    */

        System.out.println(v);
        v.copyInto(objArray);

        //objArray = v.toArray();
        //display contents of Object array
        System.out.println("Vector elements are copied into an Array. Now Array Contains..");
        for(int index=0; index < objArray.length ; index++)
            System.out.println(objArray[index]);
    }
}

/*
Output would be
Vector elements are copied into an Array. Now Array Contains..
1
2
3
4
5
*/