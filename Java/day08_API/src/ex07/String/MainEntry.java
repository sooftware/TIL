package ex07.String;

import ex03.Final.Point;

public class MainEntry {
	public static void main(String[] args) {
		int x = 999;
		String str = "abc";
		System.out.println("str : " + str);
		char ch = str.charAt(0);
		System.out.println(ch);
		
		char data[] = {'k', 'b', 's'};
		str = new String(data);
		System.out.println("str : " + str);
		System.out.println("kbs");
		
		String msg = "defgragrea";
		System.out.println("korea" + msg);	//	문자결합
		System.out.println(msg);
		
		System.out.println(msg.substring(1,5));
		
		Point p1 = new Point();
		Point p2 = new Point();
		System.out.println("p1.hashCode() : " + p1.hashCode());
		System.out.println("p2.hashCode() : " + p2.hashCode());
		System.out.println("****************************");
		
		String s1 = new String("kosta");
		String s2 = new String("kosta");
		System.out.println("s1.hashCode() : " + s1.hashCode());
		System.out.println("s2.hashCode() : " + s2.hashCode());
	}
}
