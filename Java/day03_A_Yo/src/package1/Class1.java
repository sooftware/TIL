package package1;
import java.util.*;

public class Class1 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		char ch='0';
		int count=0,i=0;
		String str=null;

		System.out.println("아무값이나 입력해주세요!");
		str=sc.next();
		while(ch != '!'){
			ch=str.charAt(i);
			count++;
			i++;
		}
		count--;
		
		System.out.println(count);
	}
}
