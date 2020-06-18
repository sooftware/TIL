package third;

import java.util.Scanner;

public class MainEntry {
	public static void main(String[] args) {
		int a=0,b=0;
		char mode='0';
		Scanner sc = new Scanner(System.in);
		
		/* a,b 숫자값 입력받기 */
		System.out.print("## 첫번째 숫자를 입력해주세요 : ");
		a=sc.nextInt();
		System.out.print("## 두번째 숫자를 입력해주세요 : ");
		b=sc.nextInt();
		/* + - * / 입력받기 및 이 4가지 아닐 시 예외처리  */
		do{
			System.out.print("## (+) : 더하기 (-) : 빼기 (*) : 곱하기 (/) : 나누기 ");
			mode=sc.next().charAt(0);
		}while(mode != '+' && mode != '-' && mode != '*' && mode != '/');
		
		/* operate 연산실행 */
		operate(a,b,mode);
	}

	/* 입력받은 연산에 따른 해당 객체 생성 및 연산해주고 결과값 출력 메서드 호출 */
	public static void operate(int a, int b, char mode) {
		int result = 0;

		/* + 입력시 Add() 객체 생성 및 더하기 연산 */
		if (mode == '+') {
			Add add = new Add();
			result = add.calculate(a, b);
			display(result);
		}
		/* - 입력시 Sub() 객체 생성 및 빼기 연산 */
		else if (mode == '-') {
			Sub sub = new Sub();
			result = sub.calculate(a, b);
			display(result);
		}
		/* * 입력시 Mul() 객체 생성 및 곱하기 연산 */
		else if (mode == '*') {
			Mul mul = new Mul();
			result = mul.calculate(a, b);
			display(result);
		}
		/*/ 입력시 Div() 객체 생성 및 나누기 연산 */
		else if (mode == '/') {
			Div div = new Div();
			result = div.calculate(a, b);
			
			if (!(result == -1)) {
				display(result);
			}
			/* 0으로 나눌 시 return을 -1 하도록 설정해놨으므로 */
			/* 0으로 나눌 시에 문구 */
			else{
				System.out.println("## 0으로는 나눌 수 없습니다.");
			}
		}

		return;
	}

	/* 연산결과값 출력 메서드 */
	public static void display(int result) {
		System.out.println("## 연산 결과는 " + result + "입니다.");
	}
}