package com.xcode.javas.hackerrank.tutorials.thirtydaysofcodechallenge;

import java.util.Scanner;

/**
 * Created by jarvis on 18/10/16.
 */
class Day10BinaryNumbers
{
    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        Scanner input = new Scanner(System.in);
        int N = input.nextInt();
        String str = binary(N);
        int count = 1;
        int max = 0;
        for(int i=1;i<str.length();i++)
        {
            if(str.charAt(i)=='1' && (str.charAt(i-1)=='1'||str.charAt(i-1)=='0'))
            {
                count++;
                if(i==str.length()-1 && max<count)
                {
                    max=count;
                }
            }

            else
            {
                if(max<count)
                    max=count;
                count=0;
            }

        }
        System.out.println(max);
    }

    public static String binary(int n)
    {
        String bin="";
        while(n!=0)
        {
            int rem = n%2;
            n = n/2;
            bin = rem+bin;
        }
        return bin;
    }
}


        /*
            Sample Input 1

            5
            Sample Output 1

            1
            Sample Input 2

            13
            Sample Output 2

            2
        */