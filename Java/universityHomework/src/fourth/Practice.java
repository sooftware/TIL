package fourth;

public class Practice {
	public static void main(String[] args) {
		Shape shape = new Shape();
		Shape line = new Line();
		
		shape.draw();
		line.draw();
	}
}

class Shape{
	public void draw(){
		System.out.println("Shape");
	}
}

class Line extends Shape{
	public void draw(){
		System.out.println("Line");
	}
}
