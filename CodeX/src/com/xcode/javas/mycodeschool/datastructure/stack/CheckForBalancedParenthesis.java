package com.xcode.javas.mycodeschool.datastructure.stack;

import java.util.Scanner;

/**
 * Created by jarvis on 17/6/17.
 */
public class CheckForBalancedParenthesis
{
    static Node1 Top;
    public static void main(String[] args)
    {
        CheckForBalancedParenthesis ob = new CheckForBalancedParenthesis();
        Scanner input = new Scanner(System.in);
        String str = input.nextLine();
        int len = str.length();
        int i;
        for (i = 0; i < len; i++)
        {
            char c = str.charAt(i);
            if (c == '(')
                ob.push(')');
            else if (c == '{')
                ob.push('}');
            else if (c == '[')
                ob.push(']');
            else
            {
                if (ob.idEmpty())
                {
                    break;
                }
                else if ((char)Top.data == c)
                    ob.pop();
                else
                    break;
            }
        }
        if (i == len && ob.idEmpty())
            System.out.println("Balanced");
        else
            System.out.println("Not Balanced");

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

    public boolean idEmpty()
    {
        Node1 temp = Top;
        if (temp == null)
            return true;
        else
            return false;
    }
}
