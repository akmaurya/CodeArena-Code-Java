package com.src.java.simuduck.quack;

public class MuteQuack implements QuackBehavior {

	@Override
	public void quack() {
		System.out.println("Mute / silence...");
	}
}
