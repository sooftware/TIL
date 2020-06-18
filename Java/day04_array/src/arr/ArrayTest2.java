package arr;
import java.util.*;

public class ArrayTest2 {
	public static void main(String[] args) {
		int[] num={3,7,99,7,7,30,7,22};
		int seek=7,count=0;
		int i=0;
		
		for(i=0;i<num.length;i++){
			if(num[i]==seek){
				count++;
			}
		}
		
		System.out.println(count);
	}
}
