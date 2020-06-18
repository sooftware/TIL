package Homework1;

public class HW1Demo {	
	public static void main(String[] args) {
		
		System.out.println("## 164p (6)");
		
		Complex c1 = new Complex(2.0);	//	실수만 인자로 주는 객체
		c1.print();
		Complex c2 = new Complex(1.5,2.5);	//	실수, 허수 둘 다 주는 객체
		c2.print();
		
		System.out.println("\n## 164p (7)");
		
		GolfClub g1 = new GolfClub();	//	인자가 없는 객체
		g1.print();
		
		GolfClub g2 = new GolfClub(8);	//	int형 인자 객체
		g2.print();
		
		GolfClub g3 = new GolfClub("피터");	//	String형 인자 객체
		g3.print();
	}
}
