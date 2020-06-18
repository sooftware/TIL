package ex02.Interface2;

public class MainEntry {
	public static void main(String[] args) {
		// 1. 자기 자신으로 객체 생성
		MultiClass mc = new MultiClass();
		mc.testView();
		mc.draw();
		System.out.println("=================");
		// 2. 부모로 객체 생성 - Shape, IDraw, Test
		Test t = new MultiClass();	// Test는 interface이기때문에
		t.testView();
		System.out.println(t.str);
		System.out.println("=================");
		
		Shape s = new MultiClass();
		s.show();
		System.out.println(s.result);
		System.out.println("=================");
	}
}
