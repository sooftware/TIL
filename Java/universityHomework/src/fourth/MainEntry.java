package fourth;

import java.util.Scanner;

public class MainEntry {
	public static void main(String[] args) {
		int a = 0, b = 0;
		char mode = '0';
		Scanner sc = new Scanner(System.in);

		System.out.print("## 첫번째 숫자를 입력해주세요 : ");
		a = sc.nextInt();
		System.out.print("## 두번째 숫자를 입력해주세요 : ");
		b = sc.nextInt();

		/* 정해진 모드 이외에 입력받았을 때 예외처리 */
		do {
			System.out.print("## (+) : 더하기 (-) : 빼기 (*) : 곱하기 (/) : 나누기 ");
			mode = sc.next().charAt(0);
		} while (mode != '+' && mode != '-' && mode != '*' && mode != '/');

		operate(a, b, mode);
	}

	/* 실질적인 연산이 이루어지는 메서드 */
	public static void operate(int a, int b, char mode) {
		int result = 0;
		StrategyPattern strategy = new StrategyPattern();		//	전략패턴의 중심이 되는 sp 객체생성

		/*
		 * # 전략패턴 사용 보통 interface를 이용하여 사용하는 것으로 알고있는데, 문제에 주어진 조건이 abstract
		 * class 사용조건이 있어서 abstract class를 이용한 전략패턴 사용 원하는 연산을 수행할 객체를 상황에 맞게
		 * 생성하여 사용한다.
		 */

		/* +일때는 Add() 객체 생성 */
		if (mode == '+') {
			strategy.setCal(new Add());
		}
		/* -일때는 Sub() 객체 생성 */
		else if (mode == '-') {
			strategy.setCal(new Sub());
		}
		/* *일때는 Mul() 객체 생성 */
		else if (mode == '*') {
			strategy.setCal(new Mul());
		}
		/*/일때는 Div() 객체 생성 */
		else if (mode == '/') {
			strategy.setCal(new Div());
		}
		
		/*
		 앞에서 원하는 객체를 생성했으므로, 
		 이제는 해당 객체에 해당하는 
		 setValue()와 calculate()를 실행한다 
		  */
		
		strategy.doSetValue(a, b);
		result = strategy.doCalculate(a, b);

		
		/* 0으로 나눌 경우 불가능 하므로, 예외처리 */
		if (result == -1) {
			System.out.println("## 0으로는 나눌 수 없습니다.");
		} else {
			display(result);
		}

		return;
	}

	/* 연산결과를 display해주는 메서드 */
	public static void display(int result) {
		System.out.println("## 연산 결과는 " + result + "입니다.");
	}
}