package com.xcode.javas.durgasoft._g_collection.collectioni.listi.vector;

/**
 * Created by jarvis on 5/7/17.
 */
/*
  Get Sub List of Java Vector Example
  This Java Example shows how to get sub list of java Vector using subList
  method by providing start and end index.
*/

import java.util.Vector;
import java.util.List;

public class _5_GetSubListOfJavaVector {

    public static void main(String[] args) {

        //create Vector object
        Vector v = new Vector();

        //Add elements to Vector
        v.add("1");
        v.add("2");
        v.add("3");
        v.add("4");
        v.add("5");

    /*
       To get a sub list of Java Vector use
       List subList(int startIndex, int endIndex) method.
       This method returns an object of type List containing elements from
       startIndex to endIndex - 1.
    */

        List lst = v.subList(1,3);

        //display elements of sub list.
        System.out.println("Sub list contains : ");
        for(int i=0; i< lst.size() ; i++)
            System.out.println(lst.get(i));

    /*
      Sub List returned by subList method is backed by original Vector. So any
      changes made to sub list will also be REFLECTED in the original Vector.
    */
        //remove one element from sub list
        Object obj = lst.remove(0);
        System.out.println(obj + " is removed from sub list");

        //print original Vector
        System.out.println("After removing " + obj + " from sub list, original Vector contains : ");
        for(int i=0; i< v.size() ; i++)
            System.out.println(v.get(i));

    }

}
/*
Output would be
Sub list contains :
2
3
2 is removed from sub list
After removing 2 from sub list, original Vector contains :
1
3
4
5
*/