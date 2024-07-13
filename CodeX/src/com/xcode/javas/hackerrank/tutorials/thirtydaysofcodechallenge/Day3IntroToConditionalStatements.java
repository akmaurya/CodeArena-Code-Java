package com.xcode.javas.hackerrank.tutorials.thirtydaysofcodechallenge;

import java.util.Scanner;

/**
 * Created by jarvis on 18/10/16.
 */
class Day3IntroToConditionalStatements
{
    public static void main(String[] args) {

        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        String ans="";
        if(n%2==1){
            ans = "Weird";
        }
        else{
            if(n>=2&&n<=5)
                ans = "Not Weird";
            if(n>=6&&n<=20)
                ans = "Weird";
            if(n>20)
                ans = "Not Weird";
            //Complete the code

        }
        System.out.println(ans);

    }
}



        /*
            Sample Input 0

            3
            Sample Output 0

            Weird
            Sample Input 1

            24
            Sample Output 1

            Not Weird
        */
