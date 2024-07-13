package com.xcode.javas.durgasoft._g_collection.collectioni.listi.vector;

/**
 * Created by jarvis on 5/7/17.
 */
/*
  Append all elements of other Collection to Java Vector Example
  This Java Example shows how to append all elements of other Collection object
  at the end of Java Vector object using addAll method. This program shows
  how to append all elements of Java ArrayList to Java Vector object.
*/

import java.util.Vector;
import java.util.ArrayList;

public class _2_AppendAllElementsOfOtherCollectionToVector {

    public static void main(String[] args) {

        //create Vector object
        Vector v = new Vector();

        //Add elements to Vector
        v.add("1");
        v.add("2");
        v.add("3");

        System.out.println(v);
        //create a new ArrayList object
        ArrayList arrayList = new ArrayList();
        arrayList.add("4");
        arrayList.add("5");



    /*
      To append all elements of another Collection to Vector use
      boolean addAll(Collection c) method.
      It returns true if the Vector was changed by the method call.
    */

        //append all elements of ArrayList to Vector
        v.addAll(arrayList);

        System.out.println(v);
        //display elements of Vector
        System.out.println("After appending all elements of ArrayList, Vector contains..");
        for(int i=0; i<v.size(); i++)
            System.out.println(v.get(i));

    }
}

/*
Output would be
After appending all elements of ArrayList, Vector contains..
1
2
3
4
5
*/