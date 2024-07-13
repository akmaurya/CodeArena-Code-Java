package com.xcode.javas.hackerrank.tutorials.thirtydaysofcodechallenge;

import java.util.Scanner;

/**
 * Created by jarvis on 18/10/16.
 */
class Node {
        int data;
        Node next;
        Node(int d)
        {
            data = d;
            next = null;
        }
}

class Day15LinkedList
{
    public static  Node insert(Node head,int data) {
        //Complete this method
        Node new1 = new Node(data);

        Node start = head;

        if (head == null)
        {
            head = new1;
        }
        else
        {
            while (start.next != null)
            {
                start = start.next;
            }
            start.next = new1;
        }

        return head;
    }

    public static void display(Node head) {
        Node start = head;
        while(start != null) {
            System.out.print(start.data + " ");
            start = start.next;
        }
    }

    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        Node head = null;
        int N = sc.nextInt();

        while(N-- > 0) {
            int ele = sc.nextInt();
            head = insert(head,ele);
        }
        display(head);
        sc.close();
    }
}

        /*
            Sample Input

            The following input is handled for you by the locked code in the editor:
            The first line contains T, the number of test cases.
            The T subsequent lines of test cases each contain an integer to be inserted at the list's tail.

            4
            2
            3
            4
            1
            Sample Output

            The locked code in your editor prints the ordered data values for each element in your list as a single line of space-separated integers:

            2 3 4 1
        */