package day_04;

public class CarDemo {
	public static void main(String[] args) {
		Car c1 = new Car("Red");
		Car c2= new Car("Blue");
		Car c3= new Car("red");
		
		System.out.println("자동차수 : "+Car.getNumOfCar()+", 빨간색 자동차 수 : " + c1.getNumOfRedCar());	
	}
}

class Car{
	private String name;
	private static int numOfCar=0;
	private static int numOfRedCar=0;
	public Car(String name){
		numOfCar++;
		
		
		
		if(name.compareToIgnoreCase("red")==0)	// case 무시하고 비교해서 같으면 0 반환
			numOfRedCar++;
		
		this.name=name;
	}
	
	public static int getNumOfCar() {
		return numOfCar;
	}
	public static void setNumOfCar(int numOfCar) {
		Car.numOfCar = numOfCar;
	}
	public int getNumOfRedCar() {
		return numOfRedCar;
	}
	public void setNumOfRedCar(int numOfRedCar) {
		this.numOfRedCar = numOfRedCar;
	}
	
	
}