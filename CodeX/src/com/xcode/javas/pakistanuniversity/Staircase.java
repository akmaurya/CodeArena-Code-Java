package com.xcode.javas.pakistanuniversity;
import java.util.*;

class Staircase
{
	public static void main(String args[])
	{
		Scanner sc=new Scanner(System.in);
		int n=sc.nextInt();

		for(int i=0;i<n;i++)
		{
			for(int j=n;j>i+1;j--)
				System.out.print("_");
			for(int j=0;j<=i;j++)
				System.out.print("#");
			System.out.println();
		}
	}
}