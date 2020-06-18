package ex01.api;
import java.util.*;

public class MainEntry {
	public static void main(String[] args) {
		String str="";
		Scanner sc = new Scanner(System.in);
		
		System.out.print("INPUT STRING : ");
		str=sc.nextLine();
		char[] str2=new char[str.length()];
		
		for(int i=0;i<str.length();i++){
				str2[i]=(char)str.charAt(i);
		}
		for(int i=0;i<str.length();i++){
			if(str2[i] == ' '){
				str2[i+1] =(char)(str2[i+1] - 32);
			}
		}
		
		System.out.println(str2);
	}
}