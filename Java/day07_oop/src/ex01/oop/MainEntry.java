package ex01.oop;

public class MainEntry {
	public static void main(String[] args) {
		Point pt = new Point();
		pt.display();
		Point pt2 = new Point(100);
		pt2.display();
		Point pt3 = new Point(10,20);
		pt3.display();
	}
}