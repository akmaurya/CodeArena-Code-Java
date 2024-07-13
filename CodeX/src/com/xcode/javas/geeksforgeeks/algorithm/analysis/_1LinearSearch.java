package com.xcode.javas.geeksforgeeks.algorithm.analysis;

/**
 * Created by jarvis on 30/6/17.
 */
public class _1LinearSearch
{
    // Linearly search x in arr[].  If x is present then return the index,
    // otherwise return -1
    int search(int arr[], int n, int x)
    {
        int i;
        for (i=0; i<n; i++)
        {
            if (arr[i] == x)
                return i;
        }
        return -1;
    }

    /* Driver program to test above functions*/
    public static void main(String[] args)
    {
        int arr[] = {1, 10, 30, 15};
        int x = 30;
        int n = arr.length;
        _1LinearSearch ob = new _1LinearSearch();
        System.out.println(x+" is present at index "+ob.search(arr, n, x));
    }
}



