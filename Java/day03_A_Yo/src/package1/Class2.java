package package1;
import java.util.*;

public class Class2 {
	public static void main(String[] args) {
		int a=1,b=1;
		
		do{
			a=1;
			do{
				System.out.print(b + " x " + a + " = " + a*b + "\t");
				a++;
			}while(a<10);
			System.out.println("");
			b++;
		}while(b<10);
	}
}
