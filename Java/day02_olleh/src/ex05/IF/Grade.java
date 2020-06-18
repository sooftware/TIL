package ex05.IF;
import java.util.*;

public class Grade {
	public static void main(String[] args) {
		// 학점을 구해봅시다
		Scanner sc = new Scanner(System.in);
		int kor,eng,com;
		int total=0;
		char grade;
		
		
		

	}
}

/*
package ex05.IF;
import java.util.*;

public class Grade {
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
		
		switch(select){
		case '+':
			op=num1+num2;
			System.out.println(op);
			break;
		case '-':
			op=num1-num2;
			System.out.println(op);
			break;
		case '*':
			op=num1*num2;
			System.out.println(op);
			break;
		case '/':
			opop=num1/(double)num2;
			System.out.printf("%.2f",opop);
			break;
		default:
			System.out.println("FAIL");
			break;
		}
	}
}
*/
/*
package ex05.IF;
import java.util.*;

public class Grade {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int[] Score={0,0,0};
		int count=0;
		char[] grade={'0','0','0'};
		
		for(int i=0;i<3;i++){
			System.out.print("INPUT SCORE" + (i+1) + "(0~100) : ");
			Score[i]=sc.nextInt();
		}
		
		for(int i=0;i<3;i++){
			if(Score[i]>=90 && Score[i]<=100){
					grade[i]='A';
			}
			else if(Score[i]>=70 && Score[i]<90){
				grade[i]='B';
			}
			else if(Score[i]>=50 && Score[i]<70){
				grade[i]='C';
			}
			else if(Score[i]<50){
				grade[i]='F';
			}
			else{
				count++;
			}
		}
		System.out.println("FAIL " + count);
		System.out.println("=====================================");
		for(int i=0;i<3;i++){
			System.out.println("GRADE " + (i+1) + " : " + grade[i] );
		}
		
	}
}
*/