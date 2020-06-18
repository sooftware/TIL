package dept3;

import java.util.Scanner;

public class MainEntry {
	public static void main(String[] args) {
		Gogaeck gg = new Gogaeck();
		main_while(gg);
	}
	
	
	/* 메인에서 도는 와일문 따로 배치 */
	public static void main_while(Gogaeck gg){
		Scanner sc = new Scanner(System.in);
		int choice = 0;
		
		while (true) {
			System.out.println("## 1. 고객정보등록");
			System.out.println("## 2. 고객정보수정");
			System.out.println("## 3. 고객정보삭제");
			System.out.println("## 4. 고객모두조회");
			System.out.println("## 5. 종료");
			do {
				choice = sc.nextInt();
			} while (choice < 1 || choice > 5);

			switch (choice) {
			case 1:
				try{
					gg.insert();
				}
				catch(GnoAlreadyExistException e){
					e.ment();
				}
				catch(isNotJuminException e){
					e.ment();
				}
				break;
			case 2:
				try{
					gg.update();
				}
				catch(GnoAlreadyExistException e){
					e.ment();
				}
				catch(isNotJuminException e){
					e.ment();
				}
				break;
			case 3:
				gg.delete();
				break;
			case 4:
				gg.display();
				break;
			case 5:
				return;
				default :
					break;
			}
		}
	}
}
