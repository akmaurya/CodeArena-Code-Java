package com.xcode.javas.mycodeschool.datastructure.singlylinkedlist;

import java.util.Scanner;

/**
 * Created by jarvis on 15/6/17.
 */
public class InsertDeleteAtNth
{
    public static Node1 Head;

    public static void main(String[] args)
    {
        Head = null;
        InsertDeleteAtNth ob = new InsertDeleteAtNth();
        int choice = 1;
        int nth, x;
        Scanner input = new Scanner(System.in);
        do
        {
            if (choice == 1)
            {
                System.out.print("\nEnter Number :-");
                x = input.nextInt();
                System.out.print("\nEnter Position :-");
                nth = input.nextInt();
                ob.insertAtNth(x, nth);
                ob.display();
            }
            if (choice == 2)
            {
                System.out.println("Enter position :-");
                nth = input.nextInt();
                ob.deleteAtNth(nth);
                ob.display();
            }
            if (choice == 0)
                System.exit(1);
            System.out.print("\nDo more/no/delete? 1/0/2");
            choice = input.nextInt();
        } while (choice != 0);

    }

    public void insertAtNth(int x, int n)
    {
        Node1 temp = new Node1();
        temp.data = x;
        temp.next = null;
        Node1 temp1;
        temp1 = Head;
        if (n == 1)
        {
            temp.next = Head;
            Head = temp;
        } else if (n > 1)
        {
            for (int i = 1; i < n - 1 && temp1 != null; i++)
            {
                temp1 = temp1.next;
            }
            temp.next = temp1.next;
            temp1.next = temp;
        }

    }

    public void display()
    {
        Node1 temp;
        temp = Head;
        System.out.print("List is:- ");
        while (temp != null)
        {
            System.out.print(temp.data);
            if (temp.next != null)
                System.out.print(" -> ");
            temp = temp.next;
        }
    }

    public void deleteAtNth(int n)
    {
        Node1 temp = Head;
        if (n == 1)
        {
            Head = temp.next;
        }
        else if (n > 1)
        {
            for (int i = 1; i < n-1 && temp != null; i++)
            {
                temp = temp.next;
            }
            System.out.println(temp.next.data);
            temp.next = temp.next.next;
        }
    }
}
