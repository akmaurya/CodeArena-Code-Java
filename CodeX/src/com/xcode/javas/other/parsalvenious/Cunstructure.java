package com.xcode.javas.other.parsalvenious;

class Cunstructure
{
	public static void main(String a[])
	{
		AAA obj=new AAA(2);
		System.out.println(""+obj.get());
	}
}

class AA
{
	int i;
	char ch;
	void set()
	{
		i=10;
	}

	int get()
	{
		return i;
	}

	AA(int in)
	{
		i=in;
	}
}