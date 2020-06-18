package java_finalExam;

public class SangSokEx {
	public static void main(String[] args) {
		Shape s1 = new Shape(); // 1번
		Shape s2 = new Circle(); // 2번
		Shape s3 = new Rect(); // 3번
	}
}

class Shape{
	public Shape(){
		System.out.println("Shape");
		draw();
	}
	
	public void draw(){
		System.out.println("Shape draw");
	}
}

class Circle extends Shape{
	public void draw(){
		System.out.println("Circle draw");
	}
}

class Rect extends Shape{
	public void draw(){
		System.out.println("Rect draw");
	}
}

/*
 이런 식으로 주고 1번 실행 결과 2번 실행 결과 3번 실행결과 하라고 중간고사 기출
 배점이 54점 만점에 18점 정도였나 그랬음 
 */
