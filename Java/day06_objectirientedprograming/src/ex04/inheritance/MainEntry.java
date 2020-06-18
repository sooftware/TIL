package ex04.inheritance;
import java.util.*;

public class MainEntry {
	public static void main(String[] args) {
		/* variable */
		int x=0,y=0;
		Scanner sc = new Scanner(System.in);
		/* variable */
		
		/* INPUT */
		System.out.println("=========Inherit========");
		System.out.print("INPUT X : ");
		x = sc.nextInt();
		System.out.print("INPUT Y : ");
		y = sc.nextInt();
		/* INPUT */
		
		/* OUTPUT 规过 1 */
		Rectangle Rt = new Rectangle(x,y);
		Rt.display();
		
		/* OUTPUT 规过 2 */
		
		Rt.setX(x);
		Rt.setY(y);;
		Rt.display();
	}
}
