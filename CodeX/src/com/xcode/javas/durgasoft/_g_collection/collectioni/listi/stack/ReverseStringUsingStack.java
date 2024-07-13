package com.xcode.javas.durgasoft._g_collection.collectioni.listi.stack;

import java.util.Stack;

/**
 * Created by jarvis on 5/7/17.
 */
public class ReverseStringUsingStack
{
    public static void main(String[] args)
    {
        Stack stack = new Stack();
        String str = "Simple String";
        for (int i = 0; i < str.length(); i++)
        {
            stack.push(str.charAt(i));
        }

        while (!stack.empty())
        {
            System.out.print(stack.peek());
            stack.pop();
        }
    }
}
