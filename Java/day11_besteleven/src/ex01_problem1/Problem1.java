package ex01_problem1;
import java.util.*;

public class Problem1 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int age;
		
		System.out.print("INPUT AGE : ");
		age=sc.nextInt();
		
		if(19<age && age<30){
			System.out.println("20대입니다.");
		}
		else if(29<age && age<50){
			System.out.println("30~40대 입니다.");
		}
		else{
			System.out.println("다시 입력해주세용!!");
		}
		
	}
}
