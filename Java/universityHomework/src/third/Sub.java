package third;

import java.util.Scanner;

public class Sub {
	int a,b;
	
	/* 입력받은 a,b를 해당 객체 a,b에 넣어준다 */
	public void setValue(int a,int b){
		this.a=a;
		this.b=b;
	}

	/* 빼기 연산 */
	public int calculate(int a,int b){
		return (a-b);
	}
}
