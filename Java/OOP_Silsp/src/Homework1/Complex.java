package Homework1;

public class Complex{
	double silsu,heosu; // 실수와 허수 field
	


	public void setHeosu(double heosu) {
		this.heosu = heosu;
	}






	public Complex(double silsu,double heosu) { // 실수, 허수 둘 다 있는 생성자
		this.silsu=silsu;
		this.heosu=heosu;
	}
	
	public void print() {
		System.out.println(silsu+" + "+heosu+"i");
	}
}