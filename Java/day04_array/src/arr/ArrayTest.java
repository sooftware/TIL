package arr;
import java.util.*;

public class ArrayTest {
	public static void main(String[] args) {
		int i=0;
		char[] ch=new char[10];
		String str=null;
		Scanner sc = new Scanner(System.in);
		
		System.out.print("INPUT 10 CHARACTER : ");
		str=sc.nextLine();
		for(i=0; i< str.length();i++){
			ch[i]=str.charAt(i);
		}
		
		for(i=0;i<10;i++){
			System.out.print(ch[i]);
		}
	}
}

