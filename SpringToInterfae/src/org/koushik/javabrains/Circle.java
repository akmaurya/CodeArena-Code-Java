package org.koushik.javabrains;

public class Circle implements Shape{
	
	private Point center;

	public Point getCenter() {
		return center;
	}

	public void setCenter(Point center) {
		this.center = center;
	}

	@Override
	public void draw() {

		System.out.println("Point of circle");
		System.out.println("Point is : ("+center.getX()+", "+center.getY()+")");
		
	}

}
