package forloop;

public class Swap {
	public static void main(String[] args) {
		int x=3,y=5,temp;
		
		System.out.println("x=" + x + ", y=" + y);
		
		temp=x;
		x=y;
		y=temp;
		
		System.out.println("x=" + x + ", y=" + y);
	}
}