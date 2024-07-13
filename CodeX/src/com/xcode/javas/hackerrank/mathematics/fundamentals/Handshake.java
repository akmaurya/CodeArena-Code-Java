package com.xcode.javas.hackerrank.mathematics.fundamentals;



import java.util.Scanner;

/**
 * Created by jarvis on 18/10/16.
 */
class Handshake
{
    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        Scanner input = new Scanner(System.in);
        int T = input.nextInt();
        while(T--!=0)
        {
            int n = input.nextInt();
            if(n==1)
                System.out.println("0");
            else
                System.out.println(n*(n-1)/2);
        }
    }
}


        /*
            Sample Input

            2
            1
            2
            Sample Output

            0
            1
        */