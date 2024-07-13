package com.xcode.javas.mycodeschool.datastructure.stack;


import java.util.Scanner;

/**
 * Created by jarvis on 16/6/17.
 */
public class StackUsingLinkedList
{
    static Node1 Top;

    public static void main(String[] args)
    {
        StackUsingLinkedList ob = new StackUsingLinkedList();
        Scanner input = new Scanner(System.in);
        int choice;
        do
        {
            System.out.println("1-Push\n2-Pop\n3-Display\n4-Exit");
            System.out.print("\nEnter your choice:-");
            choice = input.nextInt();
            int x;
            switch (choice)
            {
                case 1:
                    System.out.print("Enter a number:-");
                    x = input.nextInt();
                    ob.push(x);
                    break;

                case 2:
                    x = ob.pop();
                    System.out.println(x+" is popped");
                    break;

                case 3:
                    ob.display();
                    break;
            }
            System.out.println("\n");
        }while (choice != 4);
    }

    public void push(int x)
    {
        Node1 temp = new Node1();
        temp.data = x;
        temp.next = null;
        if (Top == null)
        {
            Top = temp;
            return;
        }
        temp.next = Top;
        Top = temp;
    }

    public int pop()
    {
        int x = -1;
        if (Top == null)
            System.out.println("Stack is underflow");
        else
        {
            x = Top.data;
            Top = Top.next;
        }
        return x;
    }

    public void display()
    {
        Node1 temp = Top;
        if (temp == null)
            System.out.println("Stack is empty");
        else
        {
            while (temp != null)
            {
                System.out.print(temp.data);
                if (temp.next != null)
                    System.out.print(" -> ");
                temp = temp.next;
            }
        }
    }
}
