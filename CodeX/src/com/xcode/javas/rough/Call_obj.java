package com.xcode.javas.rough;

class First
{
	public static void main(String s[])
	{
			int a=5,b=2;
			Second R=new Second();
			R.call(a,b);
	}
}

class Second
{
	public void call(int a,int b)
	{
		System.out.println("First No.="+a+"\nSecond No.="+b);
		System.out.println("Addition = "+(a+b));
	}
}