package day_02;

import java.util.Scanner;

/*
 * 대학 졸업 요건
 * - 최소 140
 * - 전공 70이상
 * - 교양 / 일반 각각 30 이상이거나 (교양 + 일반)이 80이상이거나
 */

public class Problem9 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		boolean limit=false, major=false, etc=false;
		
		System.out.print("전공 이수 학점 입력 : ");
		int majorInt=sc.nextInt();
		System.out.print("교양 이수 학점 입력 : ");
		int cocInt=sc.nextInt();
		System.out.print("일반 이수 학점 입력 : ");
		int etcInt=sc.nextInt();
		
		major=(majorInt>69) ? true : false;
		etc=((cocInt>29 && etcInt>29) || (cocInt+etcInt>79)) ? true : false;
		limit=((majorInt+cocInt+etcInt)>139) ? true:false;

		
		String str=(limit && major && etc) ? "가능" : "불가능"; 

		System.out.println("\n졸업 " + str + "합니다.");
	}
}
