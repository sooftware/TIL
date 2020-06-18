package dbEx;

import java.util.Scanner;

public class MainEntry {
	public static void main(String[] args) {
		DbOrcl dbo = new DbOrcl();
		main_while(dbo);
	}
	
	/* 메인에서 도는 와일문 따로 배치 */
	public static void main_while(DbOrcl dbo){
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
					dbo.insert();
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
					dbo.update();
				}
				catch(GnoAlreadyExistException e){
					e.ment();
				}
				catch(isNotJuminException e){
					e.ment();
				}
				break;
			case 3:
				dbo.delete();
				break;
			case 4:
				dbo.display();
				break;
			case 5:
				return;
				default :
					break;
			}
		}
	}
}
