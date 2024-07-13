package com.xcode.javas.geeksforgeeks.algorithm.searchingandsorting.searching;

/**
 * Created by jarvis on 30/6/17.
 */
public class _2BinarySearch
{
    public static void main(String[] args)
    {
        int arr[] = {0,1,2,3,4,5,6,7,8,9};
        _2BinarySearch ob = new _2BinarySearch();
        System.out.println("By first 5 is find at index "+ob.binarySearch1(arr, 5));
        System.out.println("Hello");
        System.out.println("By second 5 is find at index "+ob.binarySearch2(arr, 5));
        System.out.println("By recursive 5 is find at index "+ob.binarySearchRecursive(arr, 0, arr.length,5));
    }

    public int binarySearch1(int arr[], int x)
    {
        int len = arr.length;
        int start = 0, last = len-1;
        int mid;
        while (start <= last)                       // Complexity = O(log(n))
        {
            mid = (start+last)/2;
            if (arr[mid] == x)
                return mid;
            else if (arr[mid] < x)
                start = mid+1;
            else
                last = mid-1;
        }

        return -1;
    }

    public int binarySearch2(int arr[], int x)
    {
        int len = arr.length;
        int start = 0, last = len-1;
        int mid = 0;

        while (last - start > 1)                        // Complexity = O(log(n))
        {
            mid = (start+last)/2;
            if (arr[mid] <= x)
                start = mid;
            else
                last = mid;
        }
        if (arr[start] == x)
            return start;
        return -1;
    }

    public int binarySearchRecursive(int arr[], int start, int last, int x)
    {
        if (start <= last-1)
        {
            int mid = (start+(last-1))/2;
            if (arr[mid] == x)
                return mid;
            else if (arr[mid] < x)
                return binarySearchRecursive(arr, mid+1, last, x);
            else
                return binarySearchRecursive(arr, start, mid-1, x);
        }
        return -1;
    }
}
