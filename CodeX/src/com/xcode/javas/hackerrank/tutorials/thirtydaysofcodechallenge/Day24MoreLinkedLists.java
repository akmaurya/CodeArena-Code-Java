package com.xcode.javas.hackerrank.tutorials.thirtydaysofcodechallenge;

import java.util.Scanner;

/**
 * Created by jarvis on 24/10/16.
 */

class Node3{
    int data;
    Node3 next;
    Node3(int d){
        data=d;
        next=null;
    }

}

class Day24MoreLinkedLists
{
    public static Node3 removeDuplicates(Node3 head)
    {
        //Write your code here
        Node3 last = null;
        Node3 current = null;
        if (head != null)
        {
            last = head;
            current = head.next;
        }

        while (current != null)
        {
            if (current.data == last.data)
            {
                last.next = current.next;
                current = last.next;
            }
            else
            {
                last = current;
                current = current.next;
            }
        }
        return head;
    }

    public static  Node3 insert(Node3 head,int data)
    {
        Node3 p=new Node3(data);
        if(head==null)
            head=p;
        else if(head.next==null)
            head.next=p;
        else
        {
            Node3 start=head;
            while(start.next!=null)
                start=start.next;
            start.next=p;

        }
        return head;
    }
    public static void display(Node3 head)
    {
        Node3 start=head;
        while(start!=null)
        {
            System.out.print(start.data+" ");
            start=start.next;
        }
    }
    public static void main(String args[])
    {
        Scanner sc=new Scanner(System.in);
        Node3 head=null;
        int T=sc.nextInt();
        while(T-->0){
            int ele=sc.nextInt();
            head=insert(head,ele);
        }
        head=removeDuplicates(head);
        display(head);

    }
}


        /*
            Sample Input

            6
            1
            2
            2
            3
            3
            4
            Sample Output

            1 2 3 4
        */