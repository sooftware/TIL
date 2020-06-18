package overload;
import java.util.*;

public class MainEntry {
	public static void iplus(int x,int y){
		System.out.println(x+y);
		
	}
	
	public static void iplus(double x,double y){
		System.out.println(x+y);
	}
	
	public static void iplus(int x,int y,float f,double d){
		System.out.println(x+y+f+d);
	}
	
	public static void main(String[] args) {
		iplus(4.5,5.5);
		iplus(100,50);
		iplus(1,2,5.6f,1234.567);	// float는 f붙여주는 것 기억할 것!
	}
}