package com.xcode.javas.hackerrank.datastructure.arrays;

import java.util.Scanner;

/**
 * Created by jarvis on 26/10/16.
 */
class DynamicArray
{
    public static void main(String[] args)
    {
        Scanner input = new Scanner(System.in);
        int N = input.nextInt();
        int Q = input.nextInt();
        int lastAns = 0;
        int seqList[] = new int[N];
        int queries[][] = new int[Q][3];

        for (int i = 0; i < Q; i++)
        {
            for (int j = 0; j < 3; j++)
            {
                queries[i][j] = input.nextInt();
            }
        }
        for (int i = 0; i < Q; i++)
        {
            if (queries[i][0] == 1)
            {
                seqList[(queries[i][1]^lastAns)%N] = queries[i][2];
            }
            else
            {
                //seqList[(queries[i][1]^lastAns)%N] = queries[i][2];
                lastAns = seqList[(queries[i][2]%seqList.length)];

                System.out.println(lastAns);

            }
        }
    }
}


        /*
            Sample Input

            2 5
            1 0 5
            1 1 7
            1 0 3
            2 1 0
            2 1 1
            Sample Output

            7
            3
        */