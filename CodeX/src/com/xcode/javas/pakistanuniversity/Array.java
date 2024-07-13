package com.xcode.javas.pakistanuniversity;
import java.util.*;

class Array {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int N = in.nextInt();
        int i=0;
        int arr[] = new int[N];
        for(i=0; i < N; i++)
            arr[i] = in.nextInt();
        for(i=N-1;i>0;i--)
            System.out.print(arr[i]+" ");
        
    }
}
