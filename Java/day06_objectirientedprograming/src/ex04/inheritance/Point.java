package ex04.inheritance;

/* Point Start */
public class Point {
	protected int x,y;	// 보호모드 -상속하는 자손들에게 공개
	
	
	public Point(){
		System.out.println("Point CALL!!");
		x=10;
		y=10;
	}
	
	public Point(int x){
		System.out.println("Point CALL!!");
		this.x=x;
		y=10;
	}
	
	public Point(int x,int y){
		System.out.println("Point CALL!!");
		this.x=x;
		this.y=y;
	}
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
/* Point End */

/* Circle Start */
class Circle extends Point{	// 상속 - extends, 단일 상속만 지원
	protected int r;
	
	
	public Circle(){
		System.out.println("Circle CALL!!");
		this.x=10;
		this.y=10;
		r=5;
	}
	
	public Circle(int x){
		System.out.println("Circle CALL!!");
		this.x=x;
		this.y=10;
		r=5;
	}
	
	public Circle(int x,int y){
		System.out.println("Circle CALL!!");
		this.x=x;
		this.y=y;
		r=5;
	}
	
	public Circle(int x,int y,int r){
		System.out.println("Circle CALL!!");
		this.x=x;
		this.y=y;
		this.r=r;
	}
	/* setter getter method */
	
	public int getR() {
		System.out.println("Circle CALL!!");
		return r;
	}

	public void setR(int r) {
		this.r = r;
	}
	
	public void display(){
		System.out.println("x = " + x + ", y = " + y + ", r = " + r);
	}
	/* setter getter method */
}
/* Circle End */

/* Rectangle Start*/
class Rectangle extends Circle{
	public Rectangle(){
		System.out.println("Rectangle CALL!!");
		x=10;
		y=10;
		r=5;
	}
	
	public Rectangle(int x){
		System.out.println("Rectangle CALL!!");
		this.x=x;
		y=10;
		r=5;
	}
	
	public Rectangle(int x,int y){
		System.out.println("Rectangle CALL!!");
		this.x=x;
		this.y=y;
		r=5;
	}
	
	public Rectangle(int x,int y,int r){
		System.out.println("Rectangle CALL!!");
		this.x=x;
		this.y=y;
		this.r=r;
	}
	
	public void display(){
		System.out.println("x = " + x + ", y = " + y + ", r = " + r);
	}
	
	
}
/* Rectangle End*/