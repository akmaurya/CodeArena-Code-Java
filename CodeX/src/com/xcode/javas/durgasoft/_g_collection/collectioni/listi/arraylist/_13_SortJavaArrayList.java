package com.xcode.javas.durgasoft._g_collection.collectioni.listi.arraylist;

/**
 * Created by jarvis on 5/7/17.
 */
/*
  Sort elements of Java ArrayList Example
  This Java Example shows how to sort the elements of java ArrayList object using
  Collections.sort method.
*/

import java.util.ArrayList;
import java.util.Collections;

public class _13_SortJavaArrayList {

    public static void main(String[] args) {

        //create an ArrayList object
        ArrayList arrayList = new ArrayList();

        //Add elements to Arraylist
        arrayList.add("1");
        arrayList.add("3");
        arrayList.add("5");
        arrayList.add("2");
        arrayList.add("4");

    /*
      To sort an ArrayList object, use Collection.sort method. This is a
      static method. It sorts an ArrayList object's elements into ascending order.
    */

        System.out.println("Before Sort --- "+arrayList);

        Collections.sort(arrayList);

        //display elements of ArrayList
        System.out.println("ArrayList elements after sorting in ascending order : ");
        for(int i=0; i<arrayList.size(); i++)
            System.out.println(arrayList.get(i));

        System.out.println("After Sort --- "+arrayList);

    }
}

/*
Output would be
ArrayList elements after sorting in ascending order :
1
2
3
4
5
*/