package com.xcode.javas.geeksforgeeks.learning.stacks;
//Complete this code or write your own from scratch
import java.util.*;

class Solution{
    public static void main(String []argh){
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        
        Map m = new HashMap();

        for(int i = 0; i < n; i++){
            String name = in.next();
            int phone = in.nextInt();
            // Write code here
            m.put(name,""+phone);
            
        }
        while(in.hasNext()){
            String s = in.next();
            int flag=0;
            // Write code here
            if(m.containsKey(s))
                System.out.println(s+"="+m.get(s));
            else
                System.out.println("Not found");
        }
        in.close();
    }
}
