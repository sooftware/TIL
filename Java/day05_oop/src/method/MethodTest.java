package method;
import java.util.*;

public class MethodTest {
	public static void main(String[] args) {
		int x=0,y=0;
		Scanner sc = new Scanner(System.in);
		int result=0;
		
		System.out.print("INPUT X : ");
		x=sc.nextInt();
		System.out.print("INPUT Y : ");
		y=sc.nextInt();
		
		result=max(x,y);
		
		System.out.println("result is " + result);
	}
	
	public static int max(int x,int y){
		if(x>y){
			return x;
		}
		else{
			if(x==y){
				System.out.println("X=Y ERROR!!");
				return 0;
			}
			else{
				return y;
			}
		}
	}
}
