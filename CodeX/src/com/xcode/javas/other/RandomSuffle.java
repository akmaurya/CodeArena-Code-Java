package com.xcode.javas.other;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

class RandomSuffle
{
	
	private Random rand=new Random();
	private Integer arr[]=new Integer[10];
	public static void main(String arg[])
	{
		Integer no[]=new Integer[9];
		for(int i=0;i<9;i++)
			no[i]=i+1;
		RandomSuffle rs=new RandomSuffle();
		no=rs.getPosition(no);

		for(int i=0;i<9;i++)
			System.out.print(no[i]+"  ");
	}
	
	public Integer[] getPosition(Integer[] n)
	{
		Random rnd = ThreadLocalRandom.current();
	    for (int i = n.length - 1; i > 0; i--)
	    {
	      int index = rnd.nextInt(i + 1);
	      // Simple swap
	      int a = n[index];
	      n[index] = n[i];
	      n[i] = a;
	    }
		return n;
	 }
}