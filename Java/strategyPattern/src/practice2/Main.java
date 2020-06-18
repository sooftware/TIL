package practice2;
import java.util.Scanner;

abstract class Calc{   //추상클래스
   int a, b;

   public void setValue(int a, int b){
      this.a=a;
      this.b=b;
   }
   
   public abstract int calculate(int a, int b);
}

/* 연산 */
class Add extends Calc{
   public int calculate(int a, int b) {
      return a+b;
   }
}

class Sub extends Calc{
   public int calculate(int a, int b) {
      return a-b;
   }
}

class Mul extends Calc{
   public int calculate(int a, int b) {
      return a*b;
   }
}

class Div extends Calc{
   public int calculate(int a, int b) {
      if(b!=0) {   return a/b;   }   
      else {   return -1;   }
   }
}
/* 연산 */


public class Main {
   public static void main(String[] args) {
      int a, b;   //피연산자
      int Result;   //계산값 반환받을 변수
      char operator;   //연산자
      String Operator;   
      Scanner sc = new Scanner(System.in);
      
      System.out.print("두 정수와 연산자를 입력하시오>>");
      a = sc.nextInt();
      b = sc.nextInt();
      Operator = sc.next();   //띄어쓰기로 한 줄에 변수 3개 입력
      
      operator=Operator.charAt(0);
      
      Result=judge(a, b, operator);
      result(b, Result);
      sc.close();
   }
   
   public static int judge(int a, int b, char operator) {   //연산자를 판단하여 어떤 계산을 할지 선택
      int result = 0;
      Calc cal = null;

      if (operator == '+') {
        cal= new Add();
      }
      else if (operator == '-') {
         cal=new Sub();
      }
      else if (operator == '*') {
         cal=new Mul();
      }
      else if (operator == '/') {
         cal=new Div();
      }
      
      cal.setValue(a, b);
     result= cal.calculate(a, b);
      
      return result;
   }
   
   public static void result(int b, int Result) {   //나누는 수가 0이 돼서 오류가 발생한 경우와 아닌 경우를 구별해서 결과값 출력
      if(b==0)
         System.out.print("0으로 나눌 수 없습니다.");
      else
         System.out.print(Result);
   }
}
