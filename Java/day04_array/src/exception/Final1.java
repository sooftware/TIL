package exception;

public class Final1 {
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
		}finally{
			System.out.println("finally 무조건 출력됨");
		}
	}
}
/*
finally는 무조건 출력된다 예외가 생기던지 안 생기던지
*/
