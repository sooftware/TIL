package ArrayList;
import java.util.*;

public class MainEntry extends Parking {
	public static void main(String[] args) {
		Parking pk = new Parking();
		LinkedList INLIST = new LinkedList();
		LinkedList OUTLIST = new LinkedList();
		LinkedList CALCULATELIST = new LinkedList();
		Scanner sc = new Scanner(System.in);
		int mode = 0;
		boolean FAIL = false;
		/*
					index										    0+2*i						1+2*i						
					-------------------------------------------------------------------
					INLIST										고객번호				입차시간
					OUTLIST									고객번호				출차시간
					CALCULATELIST					고객번호				부과된요금
					
					-> 0 및 짝수인 index에는 3가지의 LIST에 모두 고객번호가 들어가 있으므로,이 고객번호를 기준으로 관련된 정보를 찾는다
					-> 홀수인 index에는 내가 저장하고 싶었던 정보가 들어있으므로, 0 및 짝수인 index로 매치되는 정보들을 찾고 매치되는 index+1에 해당하는 정보로 연관시킨다.
					-> 고객번호는 추가될 때마다 하나씩 늘어난다. 1,2,3 고객을 입력하고 2를 삭제하더라도 다음 고객은 4번을 부여받는다.
		 
		 */

		System.out.println("====================================");
		System.out.println("Welcome to Soo-Hwan`s Parking Management Program");
		System.out.println("====================================");

		while (true) {
			System.out.println("\n");
			System.out.println("## 1. 고객 추가");
			System.out.println("## 2. 출차 시간 입력 및 요금 계산");
			System.out.println("## 3. 고객 정보 삭제");
			System.out.println("## 4. 고객 목록 보기");
			System.out.println("## 5. 프로그램 종료");
			System.out.println("\n");
			do {
				if (FAIL) {
					System.out.println("잘못 입력하셨습니다.");
					FAIL = false;
				}
				System.out.print("SELECT MODE : ");
				mode = sc.nextInt();
				FAIL = true;
			} while (mode < 1 || mode > 5);
			FAIL=false;
			
			switch (mode) {
			case 1:
				pk.IN(INLIST);
				break;
			case 2:
				pk.calculate_charge(INLIST, OUTLIST, CALCULATELIST);
				break;
			case 3:
				pk.remove_list(INLIST, OUTLIST, CALCULATELIST);
				break;
			case 4:
				pk.display(INLIST, OUTLIST, CALCULATELIST);
				break;
			case 5:
				return;
			default:
				System.out.println("잘못입력하셨습니다.");
				break;
			}
		}
	}
}
