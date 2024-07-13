package com.xcode.javas.mycodeschool.datastructure.singlylinkedlist;

import java.util.Scanner;

/**
 * Created by jarvis on 15/6/17.
 */
public class ReverseListByIterative
{
    public static Node1 Head;
    public static void main(String[] args)
    {
        Head = null;
        ReverseListByIterative ob = new ReverseListByIterative();
        System.out.println("How many Numbers :- ");
        Scanner input = new Scanner(System.in);
        int n =input.nextInt();
        for (int i = 0; i < n; i++)
        {
            System.out.print("\nEnter "+(i+1)+" Number :-");
            int x = input.nextInt();
            ob.insert(x);
            ob.display();
        }
        ob.reverseByIteration();
        ob.display();
    }

    public void insert(int x)
    {
        Node1 temp = new Node1();
        temp.data = x;
        temp.next = Head;
        Head = temp;

    }

    public void display()
    {
        Node1 temp;
        temp = Head;
        System.out.print("\nList is:- ");
        while (temp != null)
        {
            System.out.print(temp.data);
            if(temp.next != null)
                System.out.print(" -> ");
            temp = temp.next;
        }
    }

    public void reverseByIteration()
    {
        Node1 previous, current, next;
        current = Head;
        previous = null;
        while (current != null)
        {
            next = current.next;
            current.next = previous;
            previous = current;
            current = next;
        }
        Head = previous;
    }
}


