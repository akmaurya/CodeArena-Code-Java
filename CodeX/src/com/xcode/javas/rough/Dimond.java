package com.xcode.javas.rough;

class Dimond
{
	public static void main(String s[])
	{
		int i,j,k,l;
		for (i=1;i<10;i++)
		{
			for(j=i;j<10;j++)
				System.out.print(" ");
			for(j=2;j<=i;j++)
					System.out.print(".");
			//for(j=2;j<=i;j++)
			//		System.out.print("-");
			
			for(j=1;j<i;j++)
				System.out.print(".");
			for(j=i;j<10;j++)
				System.out.print(" ");
			System.out.println();
		}
		for (i=1;i<10;i++)
		{
			for(j=0;j<i;j++)
				System.out.print(" ");
			for(j=i;j<9;j++)
					System.out.print(".");
			//for(j=2;j<=i;j++)
			//		System.out.print("-");
			
			for(j=i;j<9;j++)
				System.out.print(".");
			for(j=0;j<i;j++)
				System.out.print(" ");
			System.out.println();
		}
	}
}