package ex03.override;

public class Rect extends Point {
	int x2,y2;

	
	
	/* SET GET Start */
	
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
	
	/* SET GET End */
	
/*	public display(){
		super.display();
		System.out.println(", " + x2 + ", " + y2);
	}*/
}
