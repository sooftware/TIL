package day_06;

public class Car extends Vehicle{
	int displacement;
	int gears;
	
	public Car(String color,int speed,int displacement,int gears) {
		super(color,speed);
		this.displacement=displacement;
		this.gears=gears;
	}
	
	public void show() {
		super.show();
		System.out.println("Displacement : "+displacement);
		System.out.println("Gears : "+gears);
	}
}
