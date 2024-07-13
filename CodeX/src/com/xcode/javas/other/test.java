package com.xcode.javas.other;
import java.util.Scanner;

class test
{
    public static void main(String args[] ) throws Exception
    {

            /* Do your code here and print output*/
            Scanner input=new Scanner(System.in);
            int n=input.nextInt();

            Integer array[]=new Integer[n];

            String sarray[]=new String[n];


            String temp="";
            String res="";            
            for(int i=0;i<n;i++)
            {
            	array[i]=input.nextInt();
            	sarray[i]=array[i]+"";
            }
            for(int i=0;i<n;i++)
            {
            	for(int j=i+1;j<n;j++)
            	{
            		System.out.println("OK-"+n);
            		if(sarray[j].compareTo(sarray[i])<0)
            		{
            			temp=sarray[i];
            			sarray[i]=sarray[j];
            			sarray[j]=temp;
              		}
            	}
            }
            
            for(int j=0;j<n;j++)
            {
            	res=sarray[j]+res;
            
            }
            System.out.println(""+res);
            
    }
}