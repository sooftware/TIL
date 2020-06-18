package package1;
import java.util.*;

public class MainEntry {
	public static void main(String[] args) {
		boolean flag=true;
		
		first : {
			second : {
				third : {
					int k=100;
							System.out.println("before the break");
					
					if(flag) break second;
					
					System.out.println("This won`t execute");
				}
			}
			System.out.println("FUCK!!");
			
			
		} 
	}
}
