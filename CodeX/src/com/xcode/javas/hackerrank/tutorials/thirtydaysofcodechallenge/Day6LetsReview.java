package com.xcode.javas.hackerrank.tutorials.thirtydaysofcodechallenge;

import java.util.Scanner;

/**
 * Created by jarvis on 18/10/16.
 */
class Day6LetsReview
{
    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        Scanner input = new Scanner(System.in);
        int T = input.nextInt();
        String str = input.nextLine();
        while(T--!=0)
        {
            str = input.nextLine();
            int len = str.length();
            for(int i = 0;i<len;i=i+2)
            {
                System.out.print(str.charAt(i));
            }
            System.out.print(" ");
            for(int i = 1;i<len;i=i+2)
            {
                System.out.print(str.charAt(i));
            }
            System.out.println();
        }
    }
}


        /*
            Sample Input

            2
            Hacker
            Rank
            Sample Output

            Hce akr
            Rn ak
        */