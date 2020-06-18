package array;
import java.util.*;

public class ArrayTest2 {
	public static void main(String[] args) {
		int[][][] arr = new int [2][3][3];
		int x=0;
		Scanner sc = new Scanner(System.in);
	
		
		for(int i=0;i<arr.length;i++){
			for(int j=0;j<arr[0].length;j++){
				for(int k=0;k<arr[0][0].length;k++){
					arr[i][j][k]=(int)(Math.random()*100)+1;
					// arr[i][j][k] = new Random().nextInt(100)+1; 위와 똑같음
				}
			}
		}
		for(int i=0;i<arr.length;i++){
			for(int j=0;j<arr[0].length;j++){
				for(int k=0;k<arr[0][0].length;k++){
					System.out.println("arr["+i+"]["+j+"]["+k+ "] = " + arr[i][j][k]);
				}
			}
		}
	}
}
