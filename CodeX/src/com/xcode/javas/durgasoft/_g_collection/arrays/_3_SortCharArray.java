package com.xcode.javas.durgasoft._g_collection.arrays;

/**
 * Created by jarvis on 7/7/17.
 */
/*
   Java Sort char Array Example
   This example shows how to sort a char array using sort method of Arrays class of
   java.util package.
*/

import java.util.Arrays;

public class _3_SortCharArray {

    public static void main(String[] args) {

        //create char array
        char[] c1 = new char[]{'d','a','f','k','e'};

        //print original char array
        System.out.print("Original Array :\t ");
        for(int index=0; index < c1.length ; index++)
            System.out.print("  "  + c1[index]);

    /*
     To sort java char array use Arrays.sort() method of java.util package.
     Sort method sorts char array in ascending order and based on quicksort
     algorithm.
     There are two static sort methods available in java.util.Arrays class
     to sort a char array.
    */

        //To sort full array use sort(char[] c) method.
        Arrays.sort(c1);

        //print sorted char array
        System.out.print("\nSorted char array :\t ");
        for(int index=0; index < c1.length ; index++)
            System.out.print("  "  + c1[index]);

    /*
      To sort partial char array use
      sort(char[] c, int startIndex, int endIndex) method where startIndex is
      inclusive and endIndex is exclusive
    */

        char[] c2 = new char[]{'d','a','f','k','e'};
        Arrays.sort(c2,1,4);

        //print sorted char array
        System.out.print("\nPartially Sorted char array :\t ");
        for(int index=0; index < c2.length ; index++)
            System.out.print("  "  + c2[index]);

    }
}

/*
Output Would be

Original Array :     d  a  f  k  e
Sorted char array :     a  d  e  f  k
Partially Sorted char array :     d  a  f  k  e
*/