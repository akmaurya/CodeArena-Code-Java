package org.koushik.javabrains;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.context.ApplicationContext;

public class Triangle implements InitializingBean, DisposableBean{
	private Point pointA;
	private Point pointB;
	private Point pointC;
	private ApplicationContext context = null;
	
	public Point getPointA() {
		return pointA;
	}
	public void setPointA(Point pointA) {
		this.pointA = pointA;
	}
	public Point getPointB() {
		return pointB;
	}
	public void setPointB(Point pointB) {
		this.pointB = pointB;
	}
	public Point getPointC() {
		return pointC;
	}
	public void setPointC(Point pointC) {
		this.pointC = pointC;
	}
	
	public void draw()
	{
		System.out.println("Point A = ("+getPointA().getX()+", "+getPointA().getY()+")");
		System.out.println("Point B = ("+getPointB().getX()+", "+getPointB().getY()+")");
		System.out.println("Point C = ("+getPointC().getX()+", "+getPointC().getY()+")");
	}
	
	
	@Override
	public void destroy() throws Exception {
		System.out.println("Spring's destroy() is called");
		
	}
	@Override
	public void afterPropertiesSet() throws Exception {
		System.out.println("Spring's afterPropertiesSet()(Initialization method) is called");
		
	}
	
	public void myInitialization()
	{
		System.out.println("My initialization() method is called");
	}
	
	public void myDestroy()
	{
		System.out.println("My destroy() method is called");
	}
}
