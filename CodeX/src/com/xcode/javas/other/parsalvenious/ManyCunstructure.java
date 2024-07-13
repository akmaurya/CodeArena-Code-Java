package com.xcode.javas.other.parsalvenious;
class ManyCunstructure
{
	public static void main(String a[])
	{
		A1 obj=new A1(2);
		//A1 obj=new A1(4,'d');
		System.out.println(""+obj.get());
	}
}

class A1
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

	A1(int in)
	{
		i=in;
	}

	A1(int x, char c)
	{
		i=x;
		ch=c;
	}
}