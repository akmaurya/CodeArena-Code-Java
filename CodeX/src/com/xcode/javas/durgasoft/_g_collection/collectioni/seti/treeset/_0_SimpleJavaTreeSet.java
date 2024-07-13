package com.xcode.javas.durgasoft._g_collection.collectioni.seti.treeset;

/**
 * Created by jarvis on 7/7/17.
 */
/*
  Simple Java TreeSet example
  This simple Java Example shows how to use Java TreeSet. It also describes how to
  add something to TreeSet object using add method.
*/

import java.util.TreeSet;;

public class _0_SimpleJavaTreeSet {

    public static void main(String[] args) {

        //create object of TreeSet
        TreeSet tSet = new TreeSet();

    /*
      Add an Object to TreeSet using
      boolean add(Object obj) method of Java TreeSet class.
      This method adds an element to TreeSet if it is not already present in TreeSet.
      It returns true if the element was added to TreeSet, false otherwise.
    */

        tSet.add(new Integer("1"));
        tSet.add(new Integer("2"));
        tSet.add(new Integer("3"));
        tSet.add(new Integer("3"));   //Duplicates not allowed
    /*
      Please note that add method accepts Objects. Java Primitive values CAN NOT
      be added directly to TreeSet. It must be converted to corrosponding
      wrapper class first.
    */

        System.out.println("TreeSet contains.." + tSet);
    }
}

/*
Output of the program would be
TreeSet contains..[1, 2, 3]
*/