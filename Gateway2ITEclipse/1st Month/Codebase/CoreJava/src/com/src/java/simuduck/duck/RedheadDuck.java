package com.src.java.simuduck.duck;

import com.src.java.simuduck.fly.FlyWithWings;
import com.src.java.simuduck.quack.Quack;

public class RedheadDuck extends Duck {
	
	public RedheadDuck() {
		setFlyBehavior(new FlyWithWings());
		setQuackBehavior(new Quack());
	}
	
	@Override
	public void display() {
		System.out.println("I am a real Redhead duck");		
	}
}