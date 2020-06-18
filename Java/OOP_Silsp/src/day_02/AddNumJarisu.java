package day_02;

import java.util.Scanner;

public class AddNumJarisu {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int num = 0;
		boolean start = true;
		System.out.print("INPUT : ");
		do {
			if (start) {
				num = sc.nextInt();
				start = false;
			}else {
				System.out.print("INPUT : ");
				num=sc.nextInt();
			}
		} while (num < 100 || num > 1000);

		int result = 0;
		result += num / 100;
		num %= 100;
		result += num / 10;
		num %= 10;
		result += num;

		System.out.println("\nOUTPUT : " + result);
	}
}
