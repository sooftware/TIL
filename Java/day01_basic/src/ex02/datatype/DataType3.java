//*
package ex02.datatype;

public class DataType3 {
	public static void main(String[] args) {
		short sh = 32767; // -32768 ~ 32767 
		int num = 32769; // -21억 ~ 21억
		
		num=sh; // int = short 갸능
		System.out.println("sh="+sh);
		System.out.println("num="+num);
		
		num=32769;
		// 큰 자료형을 작은 자료형에 넣으려면 명시적 형변환을 해야한다.
		// 데이터 손실 발생
		sh=(short)num;
		System.out.println(sh); // -32767이 나온다
		// 0 1 2 .. 32767
		// -1 -2 ... -32768
		//위의 두개를 원(circle)이라고 생각하면, -쪽으로 써클을 돌게된다. 2만큼 차이가 나이 -쪽으로 두번움직여서 -32767
	}
}
//*/


/*


public class DataType3 {
	public static void main(String[] args) {
		short sh = 32767; // -32768 ~ 32767 
		int num = 32769; // -21억 ~ 21억
		
		num=sh; // int = short 갸능
		System.out.println("sh="+sh);
		System.out.println("num="+num);
		
		num=32769;
		// 큰 자료형을 작은 자료형에 넣으려면 명시적 형변환을 해야한다.
		// 데이터 손실 발생
		sh=(short)num;
		System.out.println(sh); // -32767이 나온다
		// 0 1 2 .. 32767
		// -1 -2 ... -32768
		//위의 두개를 원(circle)이라고 생각하면, -쪽으로 써클을 돌게된다. 2만큼 차이가 나이 -쪽으로 두번움직여서 -32767
	}
}
//*/