package day_03_OOP;

public class Triangle {
	private double area;
	private double width,height;
	public Triangle(double width,double height) {
		this.width=width;
		this.height=height;
		this.area=width*height*0.5;
	}
	
	public double getArea() {
		return this.area;
	}
	
	public boolean compareArea(double area1,double area2) {
		if(area==area2)	return true;
		else return false;
	}
}