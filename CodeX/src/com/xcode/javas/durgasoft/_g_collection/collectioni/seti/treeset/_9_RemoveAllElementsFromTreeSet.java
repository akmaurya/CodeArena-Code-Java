package com.xcode.javas.durgasoft._g_collection.collectioni.seti.treeset;

/**
 * Created by jarvis on 7/7/17.
 */
/*
  Remove all elements from Java TreeSet example
  This Java Example shows how to remove all elements contained in Java TreeSet
  or clear TreeSet object using clear or removeAll methods. It also shows how
  to check whether TreeSet object is empty or not using isEmpty method.
*/

import java.util.TreeSet;

public class _9_RemoveAllElementsFromTreeSet {

    public static void main(String[] args) {

        //create object of TreeSet
        TreeSet tSet = new TreeSet();

        //add elements to TreeSet object
        tSet.add(new Integer("1"));
        tSet.add(new Integer("2"));
        tSet.add(new Integer("3"));

        System.out.println("TreeSet before removal : " + tSet);

    /*
      To remove all elements from Java TreeSet or to clear TreeSet object use,
      void clear() method.
      This method removes all elements from TreeSet.
    */

        tSet.clear();
        System.out.println("TreeSet after removal : " + tSet);

    /*
      To check whether TreeSet contains any elements or not use
      boolean isEmpty() method.
      This method returns true if the TreeSet does not contains any elements
      otherwise false.
    */

        System.out.println("Is TreeSet empty ? " + tSet.isEmpty());

    /*
      Please note that removeAll method of Java TreeSet class can also be
      used to remove all elements from TreeSet object.
    */
    }
}

/*
Output would be
TreeSet before removal : [1, 2, 3]
TreeSet after removal : []
Is TreeSet empty ? true
*/