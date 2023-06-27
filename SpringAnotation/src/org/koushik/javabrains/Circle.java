package org.koushik.javabrains;

import javax.annotation.Resource;

import org.springframework.stereotype.Component;


@Component
public class Circle implements Shape{
	
	private Point center;

	public Point getCenter() {
		return center;
	}
	
	@Resource
	public void setCenter(Point center) {
		this.center = center;
	}

	@Override
	public void draw() {

		System.out.println("Point of circle");
		System.out.println("Point is : ("+center.getX()+", "+center.getY()+")");
		
	}

}
