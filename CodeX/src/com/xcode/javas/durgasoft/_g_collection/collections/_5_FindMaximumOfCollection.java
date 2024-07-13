package com.xcode.javas.durgasoft._g_collection.collections;

/**
 * Created by jarvis on 7/7/17.
 */
/*
  Find maxmimum element of Java HashSet Example
  This java example shows how to find a maximum element of Java HashSet using
  max method of Collections class.
*/

import java.util.*;

public class _5_FindMaximumOfCollection{

    public static void main(String[] args) {

        //create a HashSet object
        HashSet hashSet = new HashSet();

        //Add elements to HashSet
        hashSet.add(new Long("923740927"));
        hashSet.add(new Long("4298748382"));
        hashSet.add(new Long("2374324832"));
        hashSet.add(new Long("2473483643"));
        hashSet.add(new Long("32987432984"));

    /*
       To find maximum element of Java HashSet use,
       static Object max(Collection c) method of Collections class.

       This method returns the maximum element of Java HashSet according to
       its natural ordering.
    */
        System.out.println(hashSet);
        Object obj = Collections.max(hashSet);

        System.out.println("Maximum Element of Java HashSet is : " + obj);

    }
}
/*
Output would be
Maximum Element of Java HashSet is : 32987432984
*/