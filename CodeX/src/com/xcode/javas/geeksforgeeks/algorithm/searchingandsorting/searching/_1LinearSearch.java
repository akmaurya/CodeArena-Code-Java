package com.xcode.javas.geeksforgeeks.algorithm.searchingandsorting.searching;

/**
 * Created by jarvis on 30/6/17.
 */
public class _1LinearSearch
{
    public static void main(String[] args)
    {
        int arr[] = {2,4,6,1,7,3,0,8,5,9};
        _1LinearSearch ob = new _1LinearSearch();
        System.out.println("5 is find at index "+ob.linearSearch(arr, 5));
    }

    public int linearSearch(int arr[], int x)
    {
        int len = arr.length;
        int i = 0;
        for(i = 0; i<len;i++)                   //Complexity = O(n)
            if (arr[i] == x)
                return i;
        return -1;
    }
}
