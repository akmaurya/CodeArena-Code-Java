package com.xcode.javas.other.parsalvenious.DynamicBinding;

public class Main {

	public static void main(String[] args) {
		Dog d=new Dog();
		Fish f=new Fish();
		Test t=new Test();
		System.out.println("Dog Profile");
		t.test(d);
		System.out.println("Fish Profile");
		t.test(f);
		
	}

}
