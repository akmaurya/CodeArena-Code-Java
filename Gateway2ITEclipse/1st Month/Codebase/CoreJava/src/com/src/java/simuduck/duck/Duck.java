package com.src.java.simuduck.duck;

import com.src.java.simuduck.fly.FlyBehavior;
import com.src.java.simuduck.quack.QuackBehavior;

public abstract class Duck {
	private FlyBehavior flyBehavior;
	private QuackBehavior quackBehavior;

	public Duck() {
	}

	public void setFlyBehavior(final FlyBehavior flyBehavior) {
		this.flyBehavior = flyBehavior;
	}

	public void setQuackBehavior(final QuackBehavior quackBehavior) {
		this.quackBehavior = quackBehavior;
	}

	public abstract void display();

	public void performFly() {
		flyBehavior.fly();
	}

	public void performQuack() {
		quackBehavior.quack();
	}

	public final void swim() {
		System.out.println("All ducks float, even decoys!");
	}
}