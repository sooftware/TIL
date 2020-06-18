package ex00.scanner;

import java.util.Scanner;

public class Weight {
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		int weight=0;
		String name;
		
		System.out.print("INPUT YOUR NAME : ");
		name=sc.next();
		System.out.print("INPUT YOUR WEIGHT : ");
		weight=sc.nextInt();

		System.out.println("=========================");
		System.out.println(name + "`s WEIGHT");
		System.out.println("WEIGHT : " + weight);
	}
}
