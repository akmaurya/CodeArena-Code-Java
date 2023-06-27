package com.src.java.simuduck.duck;

import com.src.java.simuduck.fly.FlyNoWay;
import com.src.java.simuduck.quack.Squeak;


public class RubberDuck extends Duck {
	
	public RubberDuck() {
		setFlyBehavior(new FlyNoWay());
		setQuackBehavior(new Squeak());
	}
	
	@Override
	public void display() {
		System.out.println("I am a real Rubber duck");
	}
}
