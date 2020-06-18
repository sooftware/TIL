package rand;
import java.util.*;

public class Rand {
	public static void main(String[] args) {
		int i=0;
		int num=0;
		int input=0;
		Scanner sc = new Scanner(System.in);
		
		num=(int)(Math.random()*100)+1;
		
		for(i=0;i<5;i++){
			System.out.print("INPUT NUMBER : ");
			input=sc.nextInt();
			
			if(input>num){
				System.out.println("Down!!");
			}
			else if(input<num){
				System.out.println("Up!!");
			}
			else if(input==num){
				System.out.println("Great!!");
				//System.exit(0);
				break;
			}
			
			if(i==4){
				System.out.println("FAIL ¤Ì.¤Ì");
				System.out.println("ANSWER IS "+ num);
			}
		}
	}
}
