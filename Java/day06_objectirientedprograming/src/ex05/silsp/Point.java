package ex05.silsp;

import java.util.Scanner;

public class Point {
	protected int x,y;
	Scanner sc = new Scanner(System.in);
	public Point(){
		x=10;
		y=20;
	}
	public Point(int x){
		System.out.println("인자 1개 POINT CALL");
		this.x=10;
		y=20;
	}
	public Point(int x,int y){
		System.out.println("인자 2개 POINT CALL");
		this.x=10;
		this.y=20;
	}
	
	/* GET SET */
	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}
	/* GET SET */
}

class Circle extends Point{
	protected int r;
	Scanner sc = new Scanner(System.in);
	
	public Circle(){
		System.out.print("INPUT X : ");
		x=sc.nextInt();
		System.out.print("INPUT Y : ");
		y=sc.nextInt();
		System.out.print("INPUT R : ");
		r=sc.nextInt();
	}
	
	public Circle(int r){
		System.out.println("인자 1개 Circle CALL");
		this.r=r;
	}
	
	/* GET SET */
	public int getR() {
		return r;
	}

	public void setR(int r) {
		this.r = r;
	}
	/* GET SET */
}

class Rect extends Circle{
	public void display(){
		System.out.println("Rect CALL!!");
		System.out.println("x = " + x + " y = " + y + " r = " + r);
	}
}
