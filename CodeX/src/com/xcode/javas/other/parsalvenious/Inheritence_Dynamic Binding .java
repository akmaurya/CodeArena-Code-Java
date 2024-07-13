package com.xcode.javas.other.parsalvenious;

class Cunstructure1
{
	public static void main(String a[])
	{
		int i=20;
		AAA obj=new AAA(2);
		System.out.println(""+obj.get());
		BB obj1=new BB(5);
		System.out.println(""+obj1.get());
		AAA obj2=new BB();
		BB obj3=(BB) obj2;
		obj3.set();
		obj3.disp();
		System.out.println(obj3.get());
		System.out.print(i);


	}
}

class AAA
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

	AAA()
	{
		
	}

	AAA(int in)
	{
		i=in;
	}
}

class BB extends AAA
{
	float f;
	void disp()
	{
		AAA obj=new AAA();
		System.out.print(obj.get());
	}

	BB()
	{
		f=2.5f;
	}

	BB(float x)
	{
		f=x;
	}

}