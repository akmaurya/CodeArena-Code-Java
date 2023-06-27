package com.src.java.simuduck;

import com.src.java.simuduck.duck.DecoyDuck;
import com.src.java.simuduck.duck.Duck;
import com.src.java.simuduck.duck.MallardDuck;
import com.src.java.simuduck.duck.RedheadDuck;
import com.src.java.simuduck.duck.RubberDuck;

public class MiniDuckSimulator {
	public static void main(String[] args) {
		Duck mallard = new MallardDuck();
		Duck rubberDuckie = new RubberDuck();
		Duck decoy = new DecoyDuck();
		Duck redhead = new RedheadDuck();

		performAction(mallard);
		performAction(decoy);
		performAction(rubberDuckie);
		performAction(redhead);
	}

	private static void performAction(final Duck duck) {
		duck.display();
		duck.swim();
		duck.performFly();
		duck.performQuack();
		System.out.println("-------------------");
	}
}