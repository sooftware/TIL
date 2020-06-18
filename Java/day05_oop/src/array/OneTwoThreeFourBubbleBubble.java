package array;
import java.util.*;

public class OneTwoThreeFourBubbleBubble {
	public static void main(String[] args) {
		int i=0,j=0;
		int[] arr = {1,6,10,5,8,7,9,3,2,4};
		int min=0;
		int index_min=0,buf=0;
		
		System.out.println("========Before=======");
		for(i=0;i<10;i++){
			System.out.print(arr[i]+" ");
		}
		
		for(i=0;i<10;i++){
			min=arr[i];
			index_min=i;
			for(j=i+1;j<10;j++){
				if(min>arr[j]){
					min=arr[j];
					index_min=j;
				}
				if(j==9){
					buf=arr[i];
					arr[i]=arr[index_min];
					arr[index_min]=buf;
				}
			}
		}
		
		System.out.println("\n========After========");
		for(i=0;i<10;i++){
			System.out.print(arr[i]+" ");
		}
		
	}
}
