package ex01_problem1;
import java.util.*;

public class Problem2 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int n=0;
		int sum=0;
		
		System.out.print("INPUT NUMBER : ");
		n=sc.nextInt();
		
		for(int i=1;i<=n;i++){
			for(int j=1;j<=i;j++){
				sum+=j;
			}
		}
		System.out.println("sum=" + sum);
	}
}