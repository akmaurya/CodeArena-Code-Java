package com.xcode.javas.hackerrank.tutorials.thirtydaysofcodechallenge;

import java.util.*;

/**
 * Created by jarvis on 22/10/16.
 */
class Day18QueuesAndStacks
{
    char Queue[] = new char[1000];
    char Stack[] = new char[1000];
    int front = -1;
    int start =-1;
    int rear = 0;

    public void pushCharacter(char c)
    {
        Stack[++start] = c;
    }

    public void enqueueCharacter(char c)
    {
        Queue[++front] = c;
    }

    public char popCharacter()
    {
        return Stack[start--];
    }

    public char dequeueCharacter()
    {
        return Queue[rear++];
    }

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String input = scan.nextLine();
        scan.close();

        // Convert input String to an array of characters:
        char[] s = input.toCharArray();

        // Create a Solution object:
        Day18QueuesAndStacks p = new Day18QueuesAndStacks();

        // Enqueue/Push all chars to their respective data structures:
        for (char c : s) {
            p.pushCharacter(c);
            p.enqueueCharacter(c);
        }

        // Pop/Dequeue the chars at the head of both data structures and compare them:
        boolean isPalindrome = true;
        for (int i = 0; i < s.length/2; i++) {
            if (p.popCharacter() != p.dequeueCharacter()) {
                isPalindrome = false;
                break;
            }
        }

        //Finally, print whether string s is palindrome or not.
        System.out.println( "The word, " + input + ", is "
                + ( (!isPalindrome) ? "not a palindrome." : "a palindrome." ) );
    }

}


        /*
            Sample Input

            racecar
            Sample Output

            The word, racecar, is a palindrome.
        */