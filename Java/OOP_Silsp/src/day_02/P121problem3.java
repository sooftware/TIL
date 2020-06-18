package day_02;

import java.util.Scanner;

/*
 * 키보드로 입력된 양의 정수 중에서 짝수만 덧셈하여 출력하는 프로그램
 * do~while문 사용
 */

public class P121problem3 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int num = 0, result = 0;
		do {
			System.out.print("정수 입력 : ");
			num=sc.nextInt();
			if(num%2==0 && num>0)	result+=num;
		} while (num > -1);
		System.out.println("\nOUTPUT : " + result);
	}
}
