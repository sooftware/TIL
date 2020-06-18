package java_finalExam;

import java.util.Random;

public class P382 {
	public static void main(String[] args) {
		String a="Hello";
		String b="Hello";
		String c="Java";
		String d = new String("Hello");
		String e = new String("Java");
		String f = new String("Java");
		
		System.out.println( a==b);
		System.out.println( a==d);
		System.out.println( c==e);
		System.out.println( e==f);
		/*
		 true
		 false
		 false
		 false
		 */
		
		for(int i=0;i<20;i++){
			//System.out.println((int)(Math.random()*155)+100);
		}
		
		Random rd = new Random();
		for(int i=0;i<10;i++){
			int num = rd.nextInt(155);
		    System.out.println(num
		    		
		    		);
		}
	}
}
