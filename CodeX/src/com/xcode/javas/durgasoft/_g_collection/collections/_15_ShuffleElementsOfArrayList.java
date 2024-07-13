package com.xcode.javas.durgasoft._g_collection.collections;

/**
 * Created by jarvis on 7/7/17.
 */
/*
  Shuffle elements of Java ArrayList example
  This java example shows how to shuffle elements of Java ArrayList object using
  shuffle method of Collections class.
*/

import java.util.ArrayList;
import java.util.Collections;

public class _15_ShuffleElementsOfArrayList {

    public static void main(String[] args) {

        //create an ArrayList object
        ArrayList arrayList = new ArrayList();

        //Add elements to Arraylist
        arrayList.add("A");
        arrayList.add("B");
        arrayList.add("C");
        arrayList.add("D");
        arrayList.add("E");

        System.out.println("Before shuffling, ArrayList contains : " + arrayList);

    /*
      To shuffle elements of Java ArrayList use,
      static void shuffle(List list) method of Collections class.
    */

        Collections.shuffle(arrayList);

        System.out.println("After shuffling, ArrayList contains : " + arrayList);

    }
}

/*
Output would be
Before shuffling, ArrayList contains : [A, B, C, D, E]
After shuffling, ArrayList contains : [C, A, D, E, B]
*/