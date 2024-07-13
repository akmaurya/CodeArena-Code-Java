package com.xcode.javas.pakistanuniversity;
import java.util.*;

class Loops
{
	public static void main(String ar[])
	{
		int point=0;
		Scanner sc=new Scanner(System.in);
		int t=sc.nextInt();

		Integer array[][]=new Integer[t][3];

		for(int i=0;i<t;i++)
		{
			array[i][0]=sc.nextInt();
			array[i][1]=sc.nextInt();
			array[i][2]=sc.nextInt();
		}

		for(int i=0;i<t;i++)
		{
			point=0;
			for(int j=0;j<array[i][2];j++)
			{
				point=point+(int)((Math.pow(2,j)*array[i][1]));
				System.out.print((point+array[i][0])+" ");
			}
			System.out.println();
			
		}

		
	}
}