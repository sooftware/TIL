package forloop;
import java.util.*;

public class Su {
	public static void main(String[] args) {
		int count=0;
		int num=0;
		int i=0;
		char a='a',b='b';
		Scanner sc = new Scanner(System.in);
		
		System.out.print("INPUT NUM : ");
		num=sc.nextInt();
		
		while(count<num){
			if(i%2==0){
				System.out.print(a);
			}
			else{
				System.out.print(b);
			}
			i++;
			count++;
		}
	}
}
