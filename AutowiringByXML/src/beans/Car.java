package beans;

import java.util.List;
import java.util.Map;
import java.util.Set;

public class Car {
	private Engine engine;
	
	public void printData(){
		System.out.println("Engine Model Year:- "+engine.getModelYear());
	}
	
}
