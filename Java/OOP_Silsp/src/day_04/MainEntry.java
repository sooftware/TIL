package day_04;

import java.util.Scanner;

public class MainEntry {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.print(">>> NAME : ");
		String name=sc.next();
		System.out.print(">>> PASSWORD : ");
		String password=sc.next();
		System.out.print(">>> AGE : ");
		String age=sc.next();
		System.out.print(">>> ID : ");
		String id=sc.next();
		
		Member m = new Member(name,password,age,id);
		
		System.out.println("\n"+m.getName());
		System.out.println(m.getPassword());
		System.out.println(m.getAge());
		System.out.println(m.getId());
		
		System.out.println("\n===Change===\n");
		
		System.out.print(">>> NAME : ");
		m.setName(sc.next());
		System.out.print(">>> PASSWORD : ");
		m.setPassword(sc.next());
		System.out.print(">>> AGE : ");
		m.setAge(sc.next());
		System.out.print(">>> ID : ");
		m.setId(sc.next());
		
		System.out.println("\n"+m.getName());
		System.out.println(m.getPassword());
		System.out.println(m.getAge());
		System.out.println(m.getId());
	}
}
