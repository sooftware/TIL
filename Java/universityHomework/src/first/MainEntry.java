package first;

import java.util.Scanner;

public class MainEntry {
	public static void main(String[] args) {
		Rect rt = new Rect();
		/*
		 Rect객체를 생성하게 되면 자동으로 Rect의 생성자 함수가 실행 되므로
		  main에서는따로 메서드 호출을 안해주고
		  생성자함수에서 호출을 함으로써 프로그램을 구현했다
		 */
		
		
	}
}

class Rect {
	/* Rect class의 생성자 함수 (객체 생성시 자동 실행) */
	public Rect() {
		int x = 0, y = 0;
		boolean con;
		Scanner sc = new Scanner(System.in); // 입력을 받기 위한 Scanner 객체 생성

		/* boolean타입의 con이 false가 나올때까지 반복 */
		while (true) {
			System.out.print("INPUT X : ");
			x = sc.nextInt();
			System.out.print("INPUT Y : ");
			y = sc.nextInt();

			inOrNot(x, y);	// (x,y)가 사각형 안에 들어있는지 아닌지를 판별해주는 메서드
			con = cont();       // 계속 진행할 것인지 아닌지를 판별해주는 메서드

			/* 사용자가 끝내기를 원한다면 끝내주기 위한 if문 */
			if (con == false) {
				return;
			}
		}

	}

	/* (x,y)가 사각형 안에 들어있는지 아닌지를 판별해주는 메서드 */
	public void inOrNot(int x, int y) {
		if (x > 100 && x < 200 && y > 100 && y < 200) {
			System.out.println("(" + x + "," + y + ")는 사각형 안에 있습니다.");
		} else {
			System.out.println("(" + x + "," + y + ")는 사각형 안에 있지 않습니다.");
		}

		return;
	}

	/* 계속 진행할 것인지 아닌지를 판별해주는 메서드 */
	public boolean cont() {
		Scanner sc = new Scanner(System.in);
		String yesno = "";
		boolean con = true;

		do {
			System.out.print("계속하시겠습니까? (Y/N)");
			yesno = sc.next();
		} while (yesno.charAt(0) != 'y' && yesno.charAt(0) != 'Y' && yesno.charAt(0) != 'n' && yesno.charAt(0) != 'N');
/*
  사용자가 y,Y,n,N이외에 다른 값을 입력했을 때 다시 입력을 받기 위한 do~while문 처리	
  위의 4가지의 알파벳이 아닌 다른 값이 입력된다면 while문 안의 조건이 true가 되어 다시 반복을 하게 되고,
  위의 4가지 알파벳 중 하나의 값이 입력이 된다면 while문 안의 조건이 false가 되어 do~while문을 빠져나오게 된다.
 */
		
		
		switch (yesno) {
		case "y":
		case "Y":
			System.out.println("계속 진행합니다");
			con = true;
			break;
		case "n":
		case "N":
			System.out.println("프로그램을 끝냅니다.");
			con = false;
		default:
			break;
		}
		return con;
	}
}
