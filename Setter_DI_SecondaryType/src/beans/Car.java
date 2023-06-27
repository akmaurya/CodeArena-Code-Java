package beans;

public class Car {
	private String carName;
	private Engine engine;
	
	public Car(){
		System.out.println("Car Constructor");
	}
	
	public String getCarName() {
		return carName;
	}
	public void setCarName(String carName) {
		this.carName = carName;
	}
	public Engine getEngine() {
		return engine;
	}
	public void setEngine(Engine engine) {
		this.engine = engine;
	}
	
	public void printCarData(){
		System.out.println("CarName: = "+carName);
		System.out.println("Model Year: = "+engine.getModelYear());
	}
}
