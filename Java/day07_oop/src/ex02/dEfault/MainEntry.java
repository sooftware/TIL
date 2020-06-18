/* default constructor & API */

package ex02.dEfault;

public class MainEntry {
	/**
	 * 
	 * @param args 메인은 아무값도 넘겨 받지 않습니다
	 * @param x 곱을 구하는 값에 첫 번째 정수형 변수
	 * @param y 곱을 구하는 값에 두 번째 정수형 변수
	 * @param multiply 변수는 x와 y의 두 정수의 곱을 저장하는 변수
	 */
	public static void main(String[] args) {
		int x,y,multiply=1;
		char ch='A';
		String msg;
		
		x=5; y=10;
		msg="Hello Java";
		multiply=multiply(x,y);
		System.out.println("x = " + x + ", y = " + y + ", mul = " + multiply);
	}

	public static int multiply(int x, int y) {
		return x*y;
	}
}
