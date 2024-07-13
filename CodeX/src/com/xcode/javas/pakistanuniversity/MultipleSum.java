package com.xcode.javas.pakistanuniversity;
import java.util.*;

class MultipleSum
{
	public static void main(String ar[])
	{
		int sum=0;
		Scanner sc=new Scanner(System.in);
		int n=sc.nextInt();
		Integer nos[]=new Integer[n];

		for(int i=0;i<n;i++)
		{
			nos[i]=sc.nextInt();
		}

		for(int i=0;i<n;i++)
		{
			sum=sum+nos[i];
		}
		System.out.print("    "+sum);
	}
}