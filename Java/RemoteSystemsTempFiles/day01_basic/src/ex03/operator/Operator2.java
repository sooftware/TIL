//*
package ex03.operator;

public class Operator2 {
	public static void main(String[] args) {
		int a=3,b=4,c=5;
		int max=0,min=0;
		
		max=(a>b) ? ((a>c) ? a : c) : ((b>c) ? b : c);
		min=(a<b) ? ((a<c) ? a : c) : ((b<c) ? b : c);
		
		System.out.println(max);
		System.out.println(min);
	}	
}
//*/

/*/
package ex03.operator;

public class Operator2 {
	public static void main(String[] args) {
		// 삼항(조건) 연산자 : if문 대신 사용 가능 (조건) ? 참일시 : 거짓일시 ;
		

		
		// 조건 연산자 이중으로 쓰기
		int x=3, y=5, z=7, result;
		
		result=(x>y) ? x : (y>z) ? y : z;
		
		System.out.println(result);
	}
}
//*/