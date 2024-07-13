package com.xcode.javas.pakistanuniversity;
import java.util.*;
class DiagonalDifference
{
	public static void main(String ar[])
	{
		Scanner sc=new Scanner(System.in);
		int n=sc.nextInt();
		Integer matrix[][]=new Integer[n][n];

		int onDia=0,offDia=0;

		for(int i=0;i<n;i++)
		for(int j=0;j<n;j++)
		{
			matrix[i][j]=sc.nextInt();
			if(i==j&&(i+j)!=n-1)
			{
				onDia+=matrix[i][j];
				System.out.println("-------"+matrix[i][j]);
			}
			else if(i!=j&&(i+j)==n-1)
			{
				offDia+=matrix[i][j];
				System.out.println("=======-"+matrix[i][j]);
			}
		}

		System.out.println(Math.abs(onDia-offDia));
	}
}