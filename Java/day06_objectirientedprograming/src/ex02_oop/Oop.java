package ex02_oop;

/* Point Start */
class Point{
	/* 멤버변수 */ 	// 접근지정자 생략하면 default 자동 지정
	private int x,y;	
	
	public Point(){ // 생성자 함수 - default constructor
		x=y=100;
	}
	
	public Point(int... x){	// 매개변수 가변 
		// x=x; 이런 식으로 해주면 어느 x를 말하는 것인지를 컴퓨터가 모르게 된다.
		// 그래서 나오게 된 명령어 "this"
		this.x=x; // this를 하고 옆에 뜨는 x중에 고른다 
	}
	
	/* setter,getter method Start */
	public void setX(int xx){
		x=xx;
	}
	
	public int getX(){
		return x;
	}
	
	public void setY(int yy){
		y=yy;
	}
	
	public int getY(){
		return y;
	}
	/* setter,getter method End */
}
/* Point End */

class Circle{
	private int x,y,r;

	public Circle(){	// 생성자 함수 - 멤버변수 초기화 담당 return type이 없다!!
		x=10;
		y=20;
		r=3;
	}
	
	// 반지름 값 인자만 가지는 생성자함수, 매개변수 모두 다 갖는 생성자함수
	public Circle(int r){
		this.r=r;
	}
	public Circle(int x,int y,int r){
		this.x=x;
		this.y=y;
		this.r=r;
	}
	
	public void display(){
		System.out.println(x + ", " + y + ", " + r);
	}
	
	/* setter,getter method Start */
	public void setX(int xx){
		x=xx;
	}
	public void setY(int yy){
		y=yy;
	}
	public void setR(int rr){
		r=rr;
	}
	
	public int getX(){
		return x;
	}
	
	public int getY(){
		return y;
	} 
	public int getR(){
		return r;
	}
	/* setter,getter method Start */
}

/* private일 때의 방법 */
public class Oop {
	public static void main(String[] args) {
		Point pt = new Point();
		pt.setX(100);
		pt.setY(20);
		//cc.setX(100);
		//cc.setY(40);
		//cc.setR(5);
		
		Circle c2 = new Circle(5,5,5);
		c2.display();
		Circle c3 = new Circle(5,5,10);
		c3.display();
		
		// System.out.println("pt.x = " + pt.getX() + ", pt.y = " + pt.getY());
	}
}
