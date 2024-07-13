package com.xcode.javas.other.parsalvenious.DynamicBinding;

class Fish extends Animal{

	@Override
	void intake() {
		System.out.println("Fish Food");
	}

	@Override
	void sound() {
		System.out.println("Fish Sound");
	}
	
	void breath()
	{
		super.breath();
		System.out.println("with water");
	}

}
