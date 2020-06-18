package array;
import java.util.*;

public class SortSort {
	public static void main(String[] args) {
		int[] a={7,3,1,4,9,6,8};
		
		System.out.println("BEFORE SORTING");
		for(int i=0;i<a.length;i++){
			System.out.print(a[i]+" ");
		}
		System.out.println("");
		
		Arrays.sort(a);
		System.out.println("AFTER SORTING");
		for(int i=0;i<a.length;i++){
			System.out.print(a[i]+" ");
		}
	}
}
