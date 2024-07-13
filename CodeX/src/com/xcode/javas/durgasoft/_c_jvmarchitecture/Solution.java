package com.xcode.javas.durgasoft._c_jvmarchitecture;

import java.util.*;

class Solution {

    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        
        int T, N, S=0; 
        Scanner sc = new Scanner(System.in);
        T = sc.nextInt();
        
        while(T--!=0) {
            N = sc.nextInt();
            
              for(int i=1; i<N; i++) {
                if(i%3==0 || i%5==0) {
                S += i;
                System.out.println(i);
              }
                    
                if(i%15==0) {
                    S-=i;
                    System.out.println(i);
                }
              }
            }
            
            System.out.println(S);
        }
}