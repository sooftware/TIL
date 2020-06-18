package ex05.IF;
import java.util.*; 

public class Op {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int num1=0,num2=0;
		int op=0;
		double opop;
		char select='0';
		System.out.print("Input NUM1 : ");
		num1=sc.nextInt();
		System.out.print("Input NUM2 : ");
		num2=sc.nextInt();
		System.out.print("+,-,*,/ 중 선택 후 엔터를 눌러주세요");
		String str = sc.next();
		select = str.charAt(0);
		
		if(select=='+'){
			op=num1+num2;
			System.out.println(op);
		}
		else if(select=='-'){
			op=num1-num2;
			System.out.println(op);
		}
		else if(select=='*'){
			op=num1*num2;
			System.out.println(op);
		}
		else if(select=='/'){
			opop=num1/(double)num2;
			System.out.printf("%.2f",opop);
		}
	}
}
