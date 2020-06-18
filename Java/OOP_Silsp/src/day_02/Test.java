package day_02;

import java.util.Scanner;

public class Test {
	public static void main(String[] args) {
		double width,h,area;
		Scanner sc = new Scanner(System.in);
		
		System.out.print("가로 길이 입력하세요 : ");
		width=sc.nextDouble();
		System.out.print("세로 길이 입력하세요 : ");
		h=sc.nextDouble();
		area=(width*h)/2;
		
		System.out.println("넓이는 " + area +"입니다.");
	}
}
