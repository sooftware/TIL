package day_06;

public class PointTest {
	public static void main(String[] args) {
		Point p = new Point(10,20);
		MovablePoint mp = new MovablePoint(100,200,140,120);
		
		System.out.println(p.toString());
		System.out.println(mp.toString());
	}
}
