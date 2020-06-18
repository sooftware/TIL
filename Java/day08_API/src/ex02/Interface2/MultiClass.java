package ex02.Interface2;

public class MultiClass extends Shape
								implements IDraw, Test {

	int num = 180711;
	
	@Override
	public void testView() {
		System.out.println("Test Interface");
	}

	@Override
	public double calc() {
		System.out.println("Shape abstract class");
		
		return 5.5;	
	}

	@Override
	public void draw() {
		System.out.println("IDraw interface call");
	}

}