package ex01.linkedlist;

import java.util.*;

public class A {
	String[] buffer = new String[3];
	int i=0,j=0;
	Scanner sc = new Scanner(System.in);
	String con = new String();
	Gogaeck gg = new Gogaeck();
	
	public void SooHwan(LinkedList list){
		for(i=0;i<=j;i++){
			System.out.print("INPUT NAME : ");
			buffer[0] = sc.next();
			System.out.print("INPUT TEL : ");
			buffer[1] = sc.next();
			System.out.print("INPUT ADDRESS : ");
			buffer[2] = sc.next();

			gg = new Gogaeck(buffer[0], buffer[1], buffer[2]);
			list.add(gg);

			while(true){
				System.out.print("계속 진행하시겠습니까? (Y/N) ");
				con = sc.next();
				
				if (con.charAt(0) == 'n' || con.charAt(0) == 'y' || con.charAt(0) == 'N' || con.charAt(0) == 'Y') {
					if (con.charAt(0) == 'n') {
						System.out.println("끝");
						break;
					} else if (con.charAt(0) == 'N') {
						System.out.println("끝");
						break;
					}
					else if(con.charAt(0) == 'y'){
						j++;
						break;
					}
					else if(con.charAt(0) == 'Y'){
						j++;
						break;
					}
				}
				else{
					System.out.println("잘못 입력하셨습니다.");
				}
			}
		}
		output(list,gg);
	}
	
	public void output(LinkedList list,Gogaeck gg){
		System.out.println("=================");
		for ( i = 0; i < list.size(); i++) {
			Gogaeck ss = new Gogaeck();
			ss = (Gogaeck) list.get(i);
			ss.output();
			System.out.println("=================");
		}
	}
}
