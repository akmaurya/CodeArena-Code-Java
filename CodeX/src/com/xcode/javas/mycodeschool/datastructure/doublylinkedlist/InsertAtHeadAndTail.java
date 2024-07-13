package com.xcode.javas.mycodeschool.datastructure.doublylinkedlist;

//import com.sun.xml.internal.ws.server.sei.MessageFiller;

import java.util.Scanner;
import java.util.logging.Handler;
import java.util.zip.DeflaterOutputStream;

/**
 * Created by jarvis on 16/6/17.
 */
public class InsertAtHeadAndTail
{
    Node2 Head;
    public static void main(String[] args)
    {
        InsertAtHeadAndTail ob = new InsertAtHeadAndTail();
        Scanner input = new Scanner(System.in);
        int choice;
        do
        {
            System.out.println("1-Insert At Head\n2-Insert At Tail\n3-Display Forward List\n4-Display Reverse List\n4-Exit");
            System.out.print("\nEnter your choice:-");
            choice = input.nextInt();
            int x;
            switch (choice)
            {
                case 1:
                    System.out.print("Enter a number:-");
                    x = input.nextInt();
                    ob.insertAtHead(x);
                    break;

                case 2:
                    System.out.print("Enter a number:-");
                    x = input.nextInt();
                    ob.insertAtTail(x);
                    break;

                case 3:
                    ob.displayForward();
                    break;

                case 4:
                    ob.displayReverse();
                    break;
            }
            System.out.println("\n");
        }while (choice != 4);
    }

    public void insertAtHead(int x)
    {
        Node2 temp = Head;
        Node2 temp1 = getNewNode2(x);
        if (temp == null)
        {
            Head = temp1;
            return;
        }
        temp1.next = temp;
        temp.previous = temp1;
        Head = temp1;
    }

    public void insertAtTail(int x)
    {
        Node2 temp = Head;
        Node2 temp1 = getNewNode2(x);
        if (temp == null)
        {
            Head = temp1;
            return;
        }
        while (temp.next != null)
        {
            temp = temp.next;
        }
        temp.next = temp1;
        temp1.previous = temp;
    }

    public void displayForward()
    {
        Node2 temp = Head;
        System.out.print("\nForward List is:-");
        while (temp != null)
        {
            System.out.print(temp.data);
            if (temp.next != null)
                System.out.print(" <-> ");
            temp = temp.next;
        }
    }

    public void displayReverse()
    {
        Node2 temp = Head;
        System.out.print("\nReverse List is:-");
        while (temp.next != null)
            temp = temp.next;
        while (temp != null)
        {
            System.out.print(temp.data);
            if (temp.previous != null)
                System.out.print(" <-> ");
            temp = temp.previous;
        }
    }

    public Node2 getNewNode2(int x)
    {
        Node2 temp = new Node2();
        temp.data = x;
        temp.previous = null;
        temp.next = null;
        return temp;
    }
}
