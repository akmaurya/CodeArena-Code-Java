package com.xcode.javas.durgasoft._g_collection.collectioni.seti.treeset;

/**
 * Created by jarvis on 7/7/17.
 */
/*
  Get Size of Java TreeSet Example
  This Java Example shows how to get the size or nubmer of elements stored in
  Java TreeSet object using size method.
*/

import java.util.TreeSet;

public class _4_GetSizeOfJavaTreeSet {

    public static void main(String[] args) {

        //create TreeSet object
        TreeSet tSet = new TreeSet();

    /*
      To get the size of TreeSet use
      int size() method of TreeSet class. It returns the number of elements
      stored in TreeSet object.
    */
        System.out.println(tSet);
        System.out.println("Size of TreeSet : " + tSet.size());

        //add elements to TreeSet object
        tSet.add(new Integer("1"));
        tSet.add(new Integer("2"));
        tSet.add(new Integer("3"));
        System.out.println(tSet);

        System.out.println("Size of TreeSet after addition : " + tSet.size());

        //remove one element from TreeSet using remove method
        tSet.remove(new Integer("1"));
        System.out.println(tSet);
        System.out.println("Size of TreeSet after removal : " + tSet.size());
    }
}

/*
Output would be
Size of TreeSet : 0
Size of TreeSet after addition : 3
Size of TreeSet after removal : 2
*/