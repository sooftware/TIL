package method;
import java.util.*;

public class MainEntry {
	public static void main(String[] args) {	// 시작점(진입점)
		int a=0;
		String str="KimSooHwan";
		Scanner sc = new Scanner(System.in);

		System.out.print("INPUT X : ");
		int x=sc.nextInt();
		System.out.print("INPUT Y : ");
		int y=sc.nextInt();
		
		a=add(x,y);
		
		System.out.println(a);
	}
	
	// 1) 매개변수 없고, 리턴타입 없는 경우
	public static void display(){
		System.out.println("yo-yo-안녕하세-yo");
	}
	
	// 2) 매개변수 있고, 리턴타입 없는 경우
	public static void plus(int x,int y,String name){
		int sum=x+y;
		System.out.println("SUM= "+(x+y)+", "+ name);
	}
	
	public static void problem1(int x,int y,String str){
		for(int i=x-1;i<y;i++){
			System.out.print(str.charAt(i)+" ");
		}
	}
	
	// 3) 매개변수 없고, 리턴타입 있는 경우(정수형)
	public static int add(int x,int y){
		int sum=0;
		
		sum=x+y;
		
		return sum;
	}
}