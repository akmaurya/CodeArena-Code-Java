package com.xcode.javas.geeksforgeeks.learning.stacks;
//Complete this code or write your own from scratch
import java.util.*;

class Solution1{
    public static void main(String []argh){
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        String ar[][] = new String[n][2];
        for(int i = 0; i < n; i++){
            String name = in.next();
            int phone = in.nextInt();
            // Write code here
            ar[i][0] = name;
            ar[i][1] = ""+phone;
        }
        while(in.hasNext()){
            String s = in.next();
            int flag=0;
            // Write code here
            for(int i=0;i<n;i++)
            {
                if(ar[i][0].equals(s))
                {
                    System.out.println(ar[i][0]+"="+ar[i][1]);
                    flag=1;
                    break;
                }
            }
            if(flag==0)
                System.out.println("Not found");
        }
        in.close();
    }
}
