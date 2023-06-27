package org.koushik.javabrains;

public class Triangle {
	private String type;
	private int height;
	
	
	public Triangle(int height)
	{
		this.height = height;
		System.out.println(1);
	}
	
	public Triangle(String type)
	{
		this.type = type;
		System.out.println(0);
	}
	
	public Triangle(String type, int height)
	{
		this.type = type;
		this.height = height;
		System.out.println(2);
	}
	
	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public void draw()
	{
		System.out.println(getType()+" Triangle Draw of height = "+getHeight());
	}

	public int getHeight() {
		return height;
	}

	public void setHeight(int height) {
		this.height = height;
	}
}
