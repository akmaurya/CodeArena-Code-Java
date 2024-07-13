package com.xcode.javas.hackerrank.tutorials.crackingthecodinginterview;

import java.util.Scanner;

/**
 * Created by jarvis on 27/10/16.
 */
class StringsMakingAnagrams
{
    public static int numberNeeded(String first, String second)
    {
        int firstString[] = new int[26];
        int secondString[] = new int[26];
        int count = 0;
        for (int i = 0; i < first.length(); i++)
        {
            firstString[first.charAt(i)-97] += 1;
        }
        for (int i = 0; i < second.length(); i++)
        {
            secondString[second.charAt(i)-97] += 1;
        }
        for (int i = 0; i < 26; i++)
        {
            if (firstString[i] != secondString[i])
            {
                count += Math.abs(firstString[i]-secondString[i]);
            }
        }
        return count;
    }

    public static void main(String[] args)
    {
        Scanner in = new Scanner(System.in);
        String a = in.next();
        String b = in.next();
        System.out.println(numberNeeded(a, b));
    }
}


            /*
                Sample Input

                cde
                abc
                Sample Output

                4
            */