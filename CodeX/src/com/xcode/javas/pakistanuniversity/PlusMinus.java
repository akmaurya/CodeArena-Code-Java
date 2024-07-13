package com.xcode.javas.pakistanuniversity;
import java.util.*;

class PlusMinus
{
	public static void main(String ar[])
	{
		Scanner sc=new Scanner(System.in);
		int n=sc.nextInt();
		int mns=0,pls=0,zero=0;
		Integer array[]=new Integer[n];

		for(int i=0;i<n;i++)
		{
			array[i]=sc.nextInt();
			if(array[i]<0)
				mns+=1;
			else if(array[i]>0)
				pls+=1;
			else
				zero+=1;
		}
		double one=(Double.valueOf(pls))/n;
		double two=(Double.valueOf(mns))/n;
		double three=(Double.valueOf(zero))/n;

		System.out.println(""+one);
		System.out.println(""+two);
		System.out.println(""+three);
	}
}