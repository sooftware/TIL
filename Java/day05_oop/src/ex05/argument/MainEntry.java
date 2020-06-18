package ex05.argument;
import java.util.*;

public class MainEntry {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		
		if(args.length==0){
			System.out.println("ARE YOU KIDDING ME???\nINPUT DATA VALUE RIGHT NOW!!");
			return;
		}
		else{
			System.out.println(Integer.parseInt(args[0]) + Integer.parseInt(args[1]));
		}
		
	}
}
