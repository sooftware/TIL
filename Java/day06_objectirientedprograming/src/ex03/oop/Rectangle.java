package ex03.oop;

public class Rectangle {
	int x,y,x2,y2;
	
	 public Rectangle(){
		 x=100;
		 y=200;
		 x2=300;
		 y2=400;
	 }
	 
	 public Rectangle(int x){
		 this.x=x;
		 y=200;
		 x2=300;
		 y2=400;
	 }
	 public Rectangle(int x,int y){
		 this.y=y;
		 this.x=x;
		 x2=300;
		 y2=400;
	 }
	 
	 public Rectangle(int x,int y,int x2){
		 this.x=x;
		 this.y=y;
		 this.x2=x2;
		 y2=400;
	 }
	 
	 public Rectangle(int x,int y, int x2,int y2){
		 this.x=x;
		 this.y=y;
		 this.x2=x2;
		 this.y2=y2;
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

	public int getX2() {
		return x2;
	}

	public void setX2(int x2) {
		this.x2 = x2;
	}

	public int getY2() {
		return y2;
	}

	public void setY2(int y2) {
		this.y2 = y2;
	}
	
	public void display(){
		System.out.println("x = " + x + ", y = " + y + ", x2 = " + x2 + ", y2 = " + y2);
	}
	
	/* setter getter method */
}
