package day_03_OOP;

public class TriangleTest {
	public static void main(String[] args) {
		Triangle t = new Triangle(10.0,5.0);
		Triangle tt = new Triangle(25.0,1.0);
		
		if(t.compareArea(t.getArea(),tt.getArea())) {
			System.out.println("## 두 삼각형의 넓이가 같습니다!!");
		}else {
			System.out.println("## 두 삼각형의 넓이가 다릅니다!!");
		}
	}
}