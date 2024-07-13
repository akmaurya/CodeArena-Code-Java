package com.xcode.javas.hackerrank.tutorials.thirtydaysofcodechallenge;

import java.util.Scanner;

/**
 * Created by jarvis on 18/10/16.
 */
class Difference
{
    private int[] elements;
    public int maximumDifference;

    public Difference(int a[])
    {
        elements = a;
    }
    public void computeDifference()
    {
        maximumDifference = 0;
        for (int i = 0; i < elements.length ; i++)
        {
            for (int j = i+1; j < elements.length; j++)
            {
                if (Math.abs(elements[i]-elements[j])>maximumDifference)
                    maximumDifference = Math.abs(elements[i]-elements[j]);
            }
        }
    }
}
class Day14Scope
{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = sc.nextInt();
        }
        sc.close();

        Difference difference = new Difference(a);

        difference.computeDifference();

        System.out.print(difference.maximumDifference);
    }
}


        /*
            Sample Input

            3
            1 2 5
            Sample Output

            4
        */