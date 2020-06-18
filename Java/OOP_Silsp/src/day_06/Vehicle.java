package day_06;

public class Vehicle {
	String color;
	int speed;
	
	public Vehicle(String color,int speed) {
		this.color=color;
		this.speed=speed;
	}
	
	public void show() {
		System.out.println("Color : "+color);
		System.out.println("Speed : "+speed);
	}
}
