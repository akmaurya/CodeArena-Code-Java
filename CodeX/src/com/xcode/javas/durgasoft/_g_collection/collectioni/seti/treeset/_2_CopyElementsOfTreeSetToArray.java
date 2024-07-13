package com.xcode.javas.durgasoft._g_collection.collectioni.seti.treeset;

/**
 * Created by jarvis on 7/7/17.
 */
/*
  Copy all elements of Java TreeSet to an Object Array Example
  This Java Example shows how to copy all elements of Java TreeSet object to an
  array of Objects using toArray method.
*/

import java.util.TreeSet;

public class _2_CopyElementsOfTreeSetToArray {

    public static void main(String[] args) {

        //create object of TreeSet
        TreeSet tSet = new TreeSet();

        //add elements to TreeSet object
        tSet.add(new Integer("1"));
        tSet.add(new Integer("2"));
        tSet.add(new Integer("3"));

    /*
      To copy all elements of java TreeSet object into array use
      Object[] toArray() method.
    */
        System.out.println(tSet);
        Object[] objArray = tSet.toArray();

        //display contents of Object array
        System.out.println("TreeSet elements are copied into an Array. Now Array Contains..");
        for(int index=0; index < objArray.length ; index++)
            System.out.println(objArray[index]);
    }
}

/*
Output would be
TreeSet elements are copied into an Array. Now Array Contains..
1
2
3
*/