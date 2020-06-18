package ex03.oop;

public class Point{	//public class Point extends Object{
	private int x,y; // ¸â¹ö º¯¼ö

	/* default constructor */
	public Point(int x,int y){
		this.x=x;
		this.y=y;
	}
	
	public Point(int y){
		x=9999;
		this.y=y;
	}
	
	public Point(){
		x=y=100;
	}
	/* default constructor */
	
	
	/* setter getter method */
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
	
	public void display(){
		System.out.println("x = " + x + ", y = " + y);
	}
	/* setter getter method */
}
