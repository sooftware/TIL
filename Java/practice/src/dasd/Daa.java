package dasd;

import java.util.Scanner;

public class Daa {
	public static void main(String[] args) {
		double x=0;
		double a=14400000;
		double b=500;
		Scanner sc = new Scanner(System.in);
		
		
		while(true){
			System.out.print("계이름 주파수 입력 : ");
			x=sc.nextDouble();
			double Rb=(a/(x*2))-b;
			System.out.println("Rb = "+ Rb);
		}
	}
}
