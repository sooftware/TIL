package exception;

public class Exception1 {
	public static void main(String[] args) {
		try{
			int x=5,y=0;
			int result=x/y; // 예외처리 (에러가 발생할 수 있는 코드)
			
			System.out.println("result = " + result);
		}catch(ArithmeticException e){
			System.out.println("0으로 나눌 수 없습니다. ArithmeticException");
		}catch(Exception e){
			e.printStackTrace(); // 단계적으로 예외를 찾아서 출력함
			System.out.println("0으로 나눌 수 없습니다. Exception");
		}
	}
}
/*
c언어에서 if문으로 만약 ⓐ~~한 상황이 오게되면 ⓑ~~하게 처리해라이다.
ⓐ가 try에 적힌 일어날 수 있는 상황이 담긴 코드이고, ⓑ가 catch부분이다.
Exception의 중요한 점은 아래에 상위개념의 Exception을 넣어야 한다는 것이다.

예를 들면 Exception이
A{
	B{
		C
	}
}

라면 배치는

catch(C)
catch(B)
catch(A)
로 두어야 한다
*/