package com.xcode.javas.hackerearth.basic_programming.input_output;

import java.util.Scanner;

/**
 * Created by jarvis on 30/6/17.
 */
public class RoyAndProfilePicture
{
    public static void main(String[] args)
    {
        Scanner input = new Scanner(System.in);
        int L = input.nextInt();
        int N = input.nextInt();

        for (int i = 0; i < N; i++)
        {
            int W = input.nextInt();
            int H = input.nextInt();

            if (W < L || H < L)
                System.out.println("UPLOAD ANOTHER");
            else
            {
                if (H == W)
                    System.out.println("ACCEPTED");
                else
                    System.out.println("CROP IT");
            }

        }
    }
}
