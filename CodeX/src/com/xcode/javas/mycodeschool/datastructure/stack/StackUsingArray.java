package com.xcode.javas.mycodeschool.datastructure.stack;

import com.xcode.javas.mycodeschool.datastructure.doublylinkedlist.InsertAtHeadAndTail;
import com.xcode.javas.mycodeschool.datastructure.doublylinkedlist.Node2;

import java.util.Scanner;

/**
 * Created by jarvis on 16/6/17.
 */
public class StackUsingArray
{
    static int A[];
    static int MAX = 10, Top = -1;
    public static void main(String[] args)
    {
        A = new int[MAX];
        StackUsingArray ob = new StackUsingArray();
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
        if (Top >= MAX-1)
            System.out.println("Stack is overflow");
        else
        {
            A[++Top] = x;
        }
    }

    public int pop()
    {
        int x = -1;
        if (Top < 0)
            System.out.println("Stack is underflow");  //This is a bug
        else
        {
            x = A[Top--];
        }
        return x;
    }

    public void display()
    {
        if (Top < 0)
            System.out.println("Stack is empty");
        else
        {
            for (int i = Top; i >= 0; i--)
            {
                System.out.print(A[i]);
                if (i != 0)
                    System.out.print(", ");
            }
        }
    }
}
