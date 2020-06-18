package ex08.Interface;

public class MainEntry {
	public static void main(String[] args) {
		// 1. 자기 자신으로 객체 생성
		BB bb = new BB();
		bb.draw();
		System.out.println(bb.num);
		
		// 2. 부모 인터페이스로 객체 생성
		IDraw bb2 = new BB();
		System.out.println(bb2.num);
		bb2.draw();
	}
	
}
