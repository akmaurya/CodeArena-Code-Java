package com.xcode.javas.durgasoft._g_collection.collectioni.seti.treeset;

/**
 * Created by jarvis on 7/7/17.
 */
/*
  Get Sub Set from Java TreeSet example
  This Java Example shows how to get the sub Set from Java TreeSet by giving specific
  range of values using subSet method of Java TreeSet class.
*/

import java.util.TreeSet;
import java.util.SortedSet;

public class _5_GetSubSetFromTreeSet {

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
      To get the sub Set from Java TreeSet use,
      SortedSet subSet(int from, int to) method of TreeSet class.

      This method returns portion of the TreeSet whose elements range from
      from (inclusive) to to(exclusive).

      Please note that, the SortedSet returned by this method is backed by
      the original TreeSet. So any changes made to SortedSet will be
      reflected back to original TreeSet.
    */
        System.out.println(tSet);
        SortedSet sortedSet = tSet.subSet("2","5");

        System.out.println("SortedSet Contains : " + sortedSet);


    }
}

/*
Output would be
SortedSet Contains : [2, 3, 4]
*/