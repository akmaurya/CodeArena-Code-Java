package com.xcode.javas.hackerrank.datastructure.arrays;

import java.util.Scanner;

/**
 * Created by jarvis on 26/10/16.
 */
class SparseArrays
{
    public static void main(String[] args)
    {
        Scanner input = new Scanner(System.in);
        int N = input.nextInt();
        String string[] = new String[N];
        for (int i = 0; i < N; i++)
        {
            string[i] = input.next();
        }
        int Q = input.nextInt();
        String queryString[] = new String[Q];
        for (int i = 0; i < Q; i++)
        {
            queryString[i] = input.next();
        }

        int count;
        for (int i = 0; i < Q; i++)
        {
            count = 0;
            for (int j = 0; j < N; j++)
            {
                if(queryString[i].equals(string[j]))
                {
                    count++;
                }
            }
            System.out.println(count);
        }
    }
}


        /*
            Sample Input

            4
            aba
            baba
            aba
            xzxb
            3
            aba
            xzxb
            ab
            Sample Output

            2
            1
            0
        */