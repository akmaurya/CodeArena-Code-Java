package com.xcode.javas.geeksforgeeks.learning.stacks;
import java.util.*;

class BalancedBrackets {

    int top=-1;
    Character arr[];
    int size;
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();
        
        
        for(int a0 = 0; a0 < t; a0++)
        {
            BalancedBrackets sol = new BalancedBrackets();
            String s = in.next();
            int len=s.length();
            sol.arr =new Character[len];
            sol.size = len;
            String res;
            for(int i=0;i<len;i++)
            {
                if(s.charAt(i)=='{' || s.charAt(i)=='(' ||  s.charAt(i)=='[')
                    sol.push(s.charAt(i));
                else
                {
                    if(s.charAt(i) == '}' && sol.topMost() == '{')
                        sol.pop();
                    else if(s.charAt(i) == ']' && sol.topMost() == '[')
                        sol.pop();
                    else if(s.charAt(i) == ')' && sol.topMost() == '(')
                        sol.pop();
                    else 
                        {
                        res = "NO";
                    }
                }
                
                    
            }
            if(sol.topMost()==' ')
                res= "YES";
            else
                res = "NO";
            System.out.println(res);
        }
    }
    
    public void push(char ch)
    {
        if(top<size)    
            {
            arr[++top] = ch;
        }
            
    }
    
    public char pop()
    {
        if(top>=0)    
            return(arr[top--]);
        return ' ';
    }
    
    public char topMost()
    {
        if(top>=0)    
            return arr[top];
        return ' ';
    }
}
