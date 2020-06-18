package method;
import java.util.*;

public class MethoeTest2 {
	public static void main(String[] args) {
		int x=0,y=0;
		Scanner sc = new Scanner(System.in);
		
		System.out.print("INPUT X : " );
		x=sc.nextInt();
		System.out.print("INPUT Y : " );
		y=sc.nextInt();
		
		System.out.println("add = "+add(x,y));
		System.out.println("minus = "+minus(x,y));
		System.out.println("multiply = "+multiply(x,y));
		System.out.printf("divide = %.2f",divide(x,y));
	}
	
	public static int add(int x,int y){
		int sum=0;
		
		sum=x+y;
		
		return sum;
	}
	
	public static int minus(int x,int y){
		int _minus=0;
		
		
		if(x>y){
			_minus=x-y;
		}
		else{
			_minus=y-x;
		}
		
		return _minus;
	}
	
	public static int multiply(int x,int y){
		int mul=0;
		
		mul=x*y;
		
		return mul;
	}
	
	public static double divide(int x,int y){
		double _divide=0;
		
		if(y==0){
			System.out.println("Y IS 0!!!!!");
			return 0;
		}
		else{
			_divide=(double)x/(double)y;
		
			return _divide;
		}
	}
}
