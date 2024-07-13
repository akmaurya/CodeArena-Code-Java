package com.xcode.javas.preparation.xebia;


//Write a function that chunks a big array into smaller sizes. For example if I call method chunks([1,2,3,4,5] , 2)
// I should get [[1,2],[3,4], [5]]
public class ChunkArray
{
    public static void main(String[] args)
    {
        int arr[] = {1,2,3,4,5,32,34,5,4,647,57,56,67,56,756,7};
        int n=6;

        int rows = (arr.length/n)+(arr.length%n==0?0:1);
        int finalArray[][] = new int[rows][];
        int chunckLength = 0;
        int element = 0;
        for(int i=0;i<rows;i++){
            if(arr.length%n!=0 && i==rows-1){
                finalArray[i] = new int[arr.length%n];
                chunckLength = arr.length%n;
            }else {
                finalArray[i] = new int[n];
                chunckLength = n;
            }
            for(int j=0;j<chunckLength;j++){
                finalArray[i][j] = arr[element++];
            }
        }
        for(int i=0;i<finalArray.length;i++){
            System.out.print("[");
            for(int j=0;j<finalArray[i].length;j++){
                if(j<finalArray[i].length-1)
                    System.out.print(finalArray[i][j]+", ");
                else
                    System.out.print(finalArray[i][j]);
            }
            System.out.println("]");
        }















        /*int resultArray[][] =new int [(arr.length/n)+1][];
        if(arr.length<n){
            System.out.println("This");
            return;
        }
        else{
            int k=0;
            for(int i=0,l=0;i<arr.length && l<arr.length/n;i=i+n,l++){
                resultArray[l] = new int[n];
                for(int j=0;j<n;j++){
                    resultArray[i][j] = arr[k++];
                }
                if(arr.length%n >0){
                    resultArray[l] = new int[arr.length%n];
                    for(int j=0;j<arr.length%n;j++){
                        resultArray[l][j] = arr[k++];
                    }

                }
            }
        }
        System.out.println(resultArray);*/
    }
}
