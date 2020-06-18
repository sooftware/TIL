package ex08.Problem;

import java.util.*;
import java.io.*;

public class MainEntry {
	public static void main(String[] args) throws FileNotFoundException,IOException {
		Student st = new Student();
		LinkedList student = new LinkedList();
		LinkedList non_student = new LinkedList();
		Scanner sc = new Scanner(System.in);
		OutputStream os = new FileOutputStream("C:/IDE/person.txt");
		String cont;
		char mode=' ';
		
		while(true){
			st.input();
			st.list(non_student, student);
			st.file(non_student, student, os);
			
			System.out.println("계속 하시겠습니까??? (y/n)");
			cont=sc.next();
			mode=cont.charAt(0);
			switch(mode){
			case 'y' : case 'Y':
				System.out.println("계속 진행합니다.\n");
				break;
			case 'n' : case 'N' :
				System.out.println("수고");
				return;
			default:
				System.out.println("잘못입력하셨습니다.");
				break;
			}
		
		}
	}
}
