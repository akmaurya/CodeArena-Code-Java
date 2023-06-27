package com.src.java.simuduck.duck;

import com.src.java.simuduck.fly.FlyNoWay;
import com.src.java.simuduck.quack.MuteQuack;

public class DecoyDuck extends Duck {
	
	public DecoyDuck() {
		setFlyBehavior(new FlyNoWay());
		setQuackBehavior(new MuteQuack());
	}
	
	@Override
	public void display() {
		System.out.println("I am a real Decoy duck");		
	}
}
