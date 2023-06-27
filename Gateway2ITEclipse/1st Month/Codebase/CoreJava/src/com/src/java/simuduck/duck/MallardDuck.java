package com.src.java.simuduck.duck;

import com.src.java.simuduck.fly.FlyWithWings;
import com.src.java.simuduck.quack.Quack;

public class MallardDuck extends Duck {
	
	public MallardDuck() {
		setQuackBehavior(new Quack());
		setFlyBehavior(new FlyWithWings());
	}

	@Override
	public void display() {
		System.out.println("I am a real Mallard duck");
	}
}
