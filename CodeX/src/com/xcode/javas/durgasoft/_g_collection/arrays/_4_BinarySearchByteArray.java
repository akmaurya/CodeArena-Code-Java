package com.xcode.javas.durgasoft._g_collection.arrays;

/**
 * Created by jarvis on 7/7/17.
 */
/*
  Performing Binary Search on Java byte Array Example
  This java example shows how to perform binary search for an element of
  java byte array using Arrays class.
*/

import java.util.Arrays;

public class _4_BinarySearchByteArray {

    public static void main(String[] args) {
        //create byte array
        byte bArray[] = {1,2,4,5};

    /*
      To perform binary search on byte array use
      int binarySearch(byte[] b, byte value) of Arrays class. This method searches
      the byte array for specified byte value using binary search algorithm.

      Please note that the byte array MUST BE SORTED before it can be searched
      using binarySearch method.

      This method returns the index of the value to be searched, if found in the
      array.
      Otherwise it returns (- (X) - 1)
      where X is the index where the the search value would be inserted.
      i.e. index of first element that is grater than the search value
      or array.length, if all elements of an array are less than the
      search value.
    */

        //sort byte array using Arrays.sort method
        Arrays.sort(bArray);

        //value to search
        byte searchValue = 2;

        //since 2 is present in byte array, index of it would be returned
        int intResult = Arrays.binarySearch(bArray,searchValue);
        System.out.println("Result of binary search of 2 is : " + intResult);

        //lets search something which is not in byte array !
        searchValue = 3;
        intResult = Arrays.binarySearch(bArray,searchValue);
        System.out.println("Result of binary search of 3 is : " + intResult);

    }
}

/*
Output would be
Result of binary search of 2 is : 1
Result of binary search of 3 is : -3
*/