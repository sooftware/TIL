//*
package ex00.scanner;

import java.util.*;

public class MainEntry {
	public static void main(String[] args) {
		int kor=0,eng=0,com=0;
		int total=0;
		double avg=0;
		String name=null;
		
		Scanner sc = new Scanner(System.in);
		
		System.out.print("INPUT YOUR NAME : ");
		name=sc.next();
		System.out.print("INPUT KOR SCORE : ");
		kor=sc.nextInt();
		System.out.print("INPUT ENG SCORE : ");
		eng=sc.nextInt();
		System.out.print("INPUT COM SCORE : ");
		com=sc.nextInt();
		
		total=kor+eng+com;
		avg=total/3.0;
		
		System.out.println("=========================");
		System.out.println(name + "`s SCORE");
		System.out.println("KOR SCORE : " + kor);
		System.out.println("ENG SCORE : " + eng);
		System.out.println("COM SCORE : " + com);
		System.out.println("TOTAL : " + total);
		System.out.printf("AVERAGE : %.2f" , avg);
	}
}
//*/

/*
package ex00.scanner;
import java.util.Scanner;

public class MainEntry {
	public static void main(String[] args) {
		//next() vs nextLine()
		String next,line="0";
		Scanner sc = new Scanner(System.in);
		
		System.out.print("INPUT STRING : ");
		next=sc.next();
		System.out.println("next = " + next);
		sc.next(); sc.next();
		
		while(sc.next()!='\n');
		
		System.out.print("INPUT STRING : ");
		line=sc.nextLine();
		System.out.println("line = " + line);
	}
}
//*/