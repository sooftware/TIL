package ex06.random;
import java.util.*;

public class RandomClass {
	public static void main(String[] args) {
		Random rand = new Random();
		// int iNum = rand.nextInt();
		for(int i=0;i<5;i++){
			int iNum = rand.nextInt(5)+1; // 0~4
			System.out.println(iNum);
		}
	}
}
