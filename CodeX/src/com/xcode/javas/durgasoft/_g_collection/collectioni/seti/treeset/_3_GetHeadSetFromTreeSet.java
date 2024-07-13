package com.xcode.javas.durgasoft._g_collection.collectioni.seti.treeset;

/**
 * Created by jarvis on 7/7/17.
 */
/*
  Get Head Set from Java TreeSet example
  This Java Example shows how to get the portion of TreeSet containing the values
  less than the specified value using headSet method of Java TreeSet class.
*/

import java.util.SortedSet;
import java.util.TreeSet;

public class _3_GetHeadSetFromTreeSet {

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
      To get a Head Set from Java TreeSet use,
      SortedSet headSet(Object fromElement) method of Java TreeSet class.

      This method returns the portion of TreeSet containing elements less than
      fromElement.

      Please note that, the SortedSet returned by this method is backed by
      the original TreeSet. So any changes made to SortedSet will be
      reflected back to original TreeSet.
    */

        System.out.println(tSet);
        SortedSet sortedSet = tSet.headSet("3");

        System.out.println("Head Set Contains : " + sortedSet);

    }
}

/*
Output would be
Head Set Contains : [1, 2]
*/