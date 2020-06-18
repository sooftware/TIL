package ex03.oop;

public class MainEntry {
	public static void main(String[] args) {
		Point pt = new Point(); // 객체생성, 메모리에 할당, 생성자함수 자동 호출
		pt.display();
		
		Point pt2 = new Point(5,200);
		pt2.display();
		
		pt2.setX(8888);
		pt2.setY(7777);
		pt2.display();
		
		System.out.println("==================");
		
		Rectangle rt = new Rectangle(100,400);
		rt.display();
	}
}
