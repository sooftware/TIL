package day_05;

import java.util.Scanner;

public class prac1 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String url;

		do {
			System.out.print("URL 입력 : ");
			url = sc.nextLine();
			String[] spl = url.split("\\.");
			System.out.println(spl[0]);
			
			if(url.equalsIgnoreCase("bye"))  break;
			
			if (spl[spl.length - 1].equals("com")) {
				System.out.println(url + "은 com으로 끝납니다.");
			}
			
			for (int i = 0; i < spl.length; i++) {
				if (spl[i].equals("java")) {
					System.out.println(url + "은 'java'를 포함합니다.");
				}
			}
		} while (true);
			
	}

}
