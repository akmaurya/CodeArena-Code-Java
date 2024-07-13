package com.xcode.javas.durgasoft._g_collection.collectioni.listi.vector;

/**
 * Created by jarvis on 5/7/17.
 */
/*
  Insert all elements of other Collection to Specified Index of Java Vector Example
  This Java Example shows how to insert all elements of other Collection object
  at specified index of Java Vector object using addAll method.
*/

import java.util.ArrayList;
import java.util.Vector;

public class _6_InsertAllElementsOfOtherCollectionToVector {

    public static void main(String[] args) {

        //create Vector object
        Vector v = new Vector();

        //Add elements to Vector
        v.add("1");
        v.add("2");
        v.add("3");

        //create a new ArrayList object
        ArrayList arrayList = new ArrayList();
        arrayList.add("4");
        arrayList.add("5");

    /*
      To insert all elements of another Collection to sepcified index of Vector use
      boolean addAll(int index, Collection c) method.
      It returns true if the Vector was changed by the method call.
    */

        System.out.println(v);
        //insert all elements of ArrayList to Vector at index 1
        v.addAll(1,arrayList);

        System.out.println(v);

        v.add(1,arrayList);

        System.out.println(v);

        //v.addElement(1, arrayList);            //we cannot add using addElement()


        //display elements of Vector
        System.out.println("After inserting all elements of ArrayList at index 1, Vector contains..");
        for(int i=0; i<v.size(); i++)
            System.out.println(v.get(i));


    }
}
/*
Output would be
After inserting all elements of ArrayList at index 1, Vector contains..
1
4
5
2
3
*/