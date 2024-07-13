package com.xcode.javas.durgasoft._g_collection.collectioni.seti.treeset;

/**
 * Created by jarvis on 7/7/17.
 */
/*
  Get Tail Set from Java TreeSet example
  This Java Example shows how to get the portion of TreeSet containing the values
  grater than  or equal to the specified value using tailSet
  method of Java TreeSet class.
*/

import java.util.SortedSet;
import java.util.TreeSet;

public class _6_GetTailSetFromTreeSet {

    public static void main(String[] args) {

        //create TreeSet object
        TreeSet tSet = new TreeSet();

        //add elements to TreeSet
        tSet.add("1");
        tSet.add("3");
        tSet.add("2");
        tSet.add("5");
        tSet.add("4");

    /*
      To get a Tail Set from Java TreeSet use,
      SortedSet tailSet(Object fromElement) method of Java TreeSet class.

      This method returns the portion of TreeSet containing elements grater
      than or equal to fromElement.

      Please note that, the SortedSet returned by this method is backed by
      the original TreeSet. So any changes made to SortedSet will be
      reflected back to original TreeSet.
    */
        System.out.println(tSet);

        SortedSet sortedSet = tSet.tailSet("2");

        sortedSet.remove("2");
        System.out.println("Tail Set Contains : " + sortedSet);
        System.out.println(tSet);

    }
}

/*
Output would be
Tail Set Contains : [2, 3, 4, 5]
*/