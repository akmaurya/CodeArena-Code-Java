package com.xcode.javas.hackerrank.java.strings;

import java.util.Scanner;

/**
 * Created by jarvis on 7/1/17.
 */
public class JavaAnagrams_5
{
    static boolean isAnagram(String a, String b) {

        // Complete the function by writing your code here.

        int[] array = new int[26];

        if (a.length() != b.length())
            return false;
        a = a.toUpperCase();
        b = b.toUpperCase();
        for (int i = 0; i < a.length() ; i++)
        {
            array[a.charAt(i)-65] += 1;
            array[b.charAt(i)-65] -= 1;
        }
        for (int i = 0; i < 26; i++)
        {
            if (array[i] == 0)
                continue;
            else
                return false;
        }
        return true;
    }

    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);
        String a = scan.next();
        String b = scan.next();
        scan.close();
        boolean ret = isAnagram(a, b);
        System.out.println( (ret) ? "Anagrams" : "Not Anagrams" );
    }
}


        /*
            Sample Input 0

            anagram
            margana
            Sample Output 0

            Anagrams
            Sample Input 1

            anagramm
            marganaa
            Sample Output 1:

            Not Anagrams
        */