package ex1;

class TV {
	private int size;
	
	public TV(int size) { 
		this.size= size; 
	}
	
	protected int getSize() { return size; }
}

class ColorTV extends TV{
	private int color;
	
	public ColorTV(int size,int color) {
		super(size);
		this.color=color;
	}
	
	public void printProperty() {
		System.out.println(getSize()+"인치 "+color+"컬러");
	}

	public int getColor() {
		return color;
	}
	
	
}

class Complex {
	double silsu,heosu;
	
	public Complex(double silsu) {
		this.silsu=silsu;
		this.heosu=0.0;
	}
	
	public Complex(double silsu,double heosu) {
		this.silsu=silsu;
		this.heosu=heosu;
	}
	
	public void print() {
		System.out.println(silsu +" + " + heosu+"i");
	}
}

class IPTV extends ColorTV{
	String ip;
	
	public IPTV(String ip,int size,int color) {
		super(size,color);
		this.ip=ip;
	}
	
	public void printProperty() {
		System.out.println("나의 IPTV는 "+ip+" 주소의 "+getSize()+"인치 "+getColor()+"컬러");
	}
}

public class Midterm01 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int [] num = {3, 7, 2, 9, 1};
		
		System.out.println("## Problem1");
		printStar();
		System.out.println("\n## Problem2");
		System.out.println("최대값: "+returnMaxVal(num));
		// 3번 문제 코드
		System.out.println("\n## Problem3");
		Complex c1 = new Complex(2.0);
		c1.print();
		Complex c2 = new Complex(1.5, 2.5);
		c2.print();
		
		System.out.println("\n## Problem4-1");
		//4.(1)번 문제 코드
		ColorTV myTV = new ColorTV(32, 1024);
		myTV.printProperty();
		
		//4.(2)번 문제 코드
		System.out.println("\n## Problem4-2");
		IPTV ipTV = new IPTV("127.0.0.1", 32, 2048);
		ipTV.printProperty();
	}
	public static void printStar() {
		for(int i=0;i<5;i++) {
			for(int j=0;j<4-i;j++) {
				System.out.print("  ");
			}
			for(int j=0;j<=i;j++) {
				System.out.print("*");
			}
			System.out.println();
		}
	}
	
	public static int returnMaxVal(int [] n) {
		int max=n[0];
		for(int i=1;i<n.length;i++) {
			if(n[i]>max) {
				max=n[i];
			}
		}
		return max;
	}
}
