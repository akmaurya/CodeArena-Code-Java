package com.xcode.javas.durgasoft._g_collection.collectioni.seti.treeset;

/**
 * Created by jarvis on 7/7/17.
 */
/*
  Remove specified element from Java TreeSet example
  This Java Example shows how to remove a specified object or element
  contained in Java TreeSet object using remove method.
*/

import java.util.TreeSet;

public class _10_RemoveSpecifiedElementFromTreeSet {

    public static void main(String[] args) {

        //create object of TreeSet
        TreeSet tSet = new TreeSet();

        //add elements to TreeSet object
        tSet.add(new Integer("1"));
        tSet.add(new Integer("2"));
        tSet.add(new Integer("3"));

        System.out.println("TreeSet before removal : " + tSet);

    /*
      To remove an element from Java TreeSet object use,
      boolean remove(Object o) method.
      This method removes an element from TreeSet if it is present and returns
      true. Otherwise remove method returns false.
    */

        
        boolean blnRemoved = tSet.remove(new Integer("2"));
        System.out.println("Was 2 removed from TreeSet ? " + blnRemoved);

        System.out.println("TreeSet after removal : " + tSet);
    }
}

/*
Output would be
TreeSet before removal : [1, 2, 3]
Was 2 removed from TreeSet ? true
TreeSet after removal : [1, 3]
*/