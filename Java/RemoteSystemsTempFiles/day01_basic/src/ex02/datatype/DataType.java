package ex02.datatype;

public class DataType {
	static int Num; // 자바는 원래 모두 초기화해줘야 하지만 static경우 정수형 : 0 , 실수형 : 0.0, 문자열 : NULL로 초기화된다
	public static void main(String[] args) {
		float f=33.4567F; // 자바에서는 float일때 F로 표시해준다
		
		System.out.println(100);
		System.out.println(200L); // Long형 (L로 표시)
		System.out.println(12.34); // double
	}
}
