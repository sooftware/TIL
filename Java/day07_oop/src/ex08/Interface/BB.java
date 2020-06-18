package ex08.Interface;

public class BB implements IDraw {
	@Override
	public void draw() {
		System.out.println("BB클래스에서 인터페이스 IDraw의 method OVERRIDE!!");
	}
}
