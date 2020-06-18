//*
package ex05.IF;

import java.util.Scanner;

public class MainEntry {
	public static void main(String[] args) {
		char ch='0';
		Scanner sc = new Scanner(System.in);
		
		
		System.out.print("INPUT ALPHABET : ");
/*		String str = sc.next();
		ch = str.charAt(0);*/
		//ch = new Scanner(System.in).next().charAt(0);
		ch = sc.next().charAt(0);
		
		if(ch>='a' && ch<='z'){
			ch-=32;
		}
		else if(ch>='A' && ch<='Z'){
			ch+=32;
		}
		
		System.out.println((char)ch);
	}
}
//*/

/*
package ex05.IF;

import java.util.Scanner;

public class MainEntry {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int year=0;
		
		System.out.print("INPUT YEAR THAT YOU ARE BORNED : ");
		year=sc.nextInt();
		
		if(year%4==2){
			System.out.println("You were borned in the year of the worldcup!");
		}
		else{
			System.out.println("You were borned in the year when the World Cup was not held.");
		}
		
	}
}
//*/