package ArrayList;

class Super{
	public void draw(){
		draw();
		System.out.println("Super");
	}
}

class Sub extends Super{
	public void draw(){
		super.draw();
		System.out.println("Sub");
	}
}

public class Test {
	public static void main(String[] args) {
		Super a =new Sub();
		Sub b = new Sub();
		Super c = new Super();
		
		System.out.println("1st");
		a.draw();
		System.out.println("2nd");
		b.draw();
		System.out.println("3rd");
		c.draw();
	}
}
