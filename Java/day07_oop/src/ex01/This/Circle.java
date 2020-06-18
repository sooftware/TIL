package ex01.This;

public class Circle extends Point{
	int r;

	public Circle(){
		r=3;
		System.out.println("Sub Constructor");
	}
	
	public Circle(int r){
		this.r=r;
		System.out.println("Sub Constructor1");
	}
	
	/* SET GET */
	
	public int getR() {
		return r;
	}

	public void setR(int r) {
		this.r = r;
	}
	
	/* SET GET */
	
	public void display(){
		super.display();
		System.out.println(", r = " + r);
	}
}
