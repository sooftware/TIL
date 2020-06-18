package ex01.This;

public class Point {
	int x,y;

	public Point(){
		this(2,5);
		System.out.println("Super Constructor");
	}
	
	public Point(int x,int y){
		this.x=x;
		this.y=y;
		System.out.println("Super Constructor2");
	}
	
	public Point(int x){
		this(x,999);
	}
	
	/* SET GET */
	
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
	
	/* SET GET */
	
	public void display(){
		System.out.print("x = " + x + ", y = " + y);
	}
}
