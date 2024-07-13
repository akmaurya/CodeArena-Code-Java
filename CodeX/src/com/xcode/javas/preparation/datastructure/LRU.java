package com.xcode.javas.preparation.datastructure;

public class LRU
{
    public static void main(String[] args)
    {
        int arr[] = {3,2,6,3,8,1,6,3,7,4,1,9,4,5,7,8,9,1,7};
        int window[] = new int[6];


        for(int i=0;i<arr.length;i++){
            for(int j=0;j<window.length;j++){
                if(!(arr[i]==window[j]) && (j==window.length-1)){
                    int k=window.length-1;
                    for(;k>0;k--){
                        window[k] = window[k-1];
                    }
                    window[k] = arr[i];
                }else if(arr[i]==window[j]){
                    int k=j;
                    for(;k>0;k--){
                        window[k] = window[k-1];
                    }
                    window[k] = arr[i];
                    break;
                }

            }
            System.out.print(i+"--("+arr[i]+")-");
            for(int l=0;l<window.length-1;l++)
                System.out.print(window[l]+"---");
            System.out.println();
        }
    }
}
