package com.xcode.javas.rough;

class Triangle2
{
	public static  void main(String s[])
	{
		int i,j;
		for(i=1;i<=5;i++)
		{
			for(j=i;j<=5;j++)
				System.out.print(i);
			System.out.println();
		}
		for(i=5;i>=1;i--)
		{
			for(j=i;j<=5;j++)
				System.out.print(i);
			System.out.println();

		}
	}
}