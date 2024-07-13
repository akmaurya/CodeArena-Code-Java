package com.xcode.javas.durgasoft._g_collection.collectioni.seti.treeset;

/**
 * Created by jarvis on 7/7/17.
 */
/*
  Check if a particular value exists in Java TreeSet example
  This Java Example shows how to check if TreeSet object contains a particular
  value using contains method of TreeSet class.
*/

import java.util.Comparator;
import java.util.TreeSet;

public class _1_CheckValueOfTreeSet {

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
      To check whether a particular value exists in TreeSet use
      boolean contains(Object value) method of TreeSet class.
      It returns true if the TreeSet contains the value, otherwise false.
    */

        System.out.println(tSet);

        TreeSet tSet1 = new TreeSet(Comparator.reverseOrder());
        tSet1.add("1");
        tSet1.add("3");
        tSet1.add("2");
        tSet1.add("5");
        tSet1.add("4");

        System.out.println(tSet1);

        boolean blnExists = tSet.contains("3");
        System.out.println("3 exists in TreeSet ? : " + blnExists);
    }
}

/*
Output would be
3 exists in TreeSet ? : true
*/