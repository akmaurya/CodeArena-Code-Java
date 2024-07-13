package com.xcode.javas.mycodeschool.datastructure.stack;

import java.util.Scanner;

/**
 * Created by jarvis on 17/6/17.
 */
public class ReverseStringUsingStack
{
    Node1 Top;
    public static void main(String[] args)
    {
        ReverseStringUsingStack ob = new ReverseStringUsingStack();
        Scanner input = new Scanner(System.in);
        String str = input.nextLine();
        int len = str.length();
        for (int i = 0; i < len; i++)
            ob.push(str.charAt(i));
        int condition;
        while ((condition = ob.pop()) != -1)
            System.out.print((char) condition);
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
        int x;
        if (Top == null)
            x = -1;
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
