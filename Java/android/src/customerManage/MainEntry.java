package customerManage;

import java.util.ArrayList;
import java.util.Scanner;

public class MainEntry {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		ArrayList<Customer> customerList = new ArrayList<Customer>();
		int mode = -1;
		String title = "\\t### Customer Management Program ###\\n";
		String[] menu = {"## 0. 고객 명단 출력",
						 "## 1. 신규 고객 등록",
						 "## 2. 고객 정보 수정",
						 "## 3. 고객 포인트 조회",
						 "## 4. 고객 정보 수정",
						 "## 5. 고객 삭제",
						 "## 6. 프로그램 종료"}; 
		
		/* User Interface */
		System.out.println(title);
		do {
			for(int i = 0;i < 7; i++)
				System.out.println(menu[i]);
		}while(mode<0 || mode>6);
		
		return;
	}
}
