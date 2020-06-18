package array;

public class OneTwoThreeFourBubbleBubble2 {
	public static void main(String[] args) {
		int i=0,j=0;
		int temp=0;
		int[] arr={10,9,8,7,6,5,4,3,2,1};
		
		System.out.println("===========BEFORE==========");
		for(i=0;i<10;i++){
			System.out.print(arr[i]+" ");
		}
		System.out.println("");
		
		for(i=0;i<9;i++){
			for(j=0;i<9;j++){
				if(arr[j]>arr[j+1]){
					temp=arr[j];
					arr[j]=arr[j+1];
					arr[j+1]=temp;
				}
			}
		}
		System.out.println("===========AFTER==========");
		for(i=0;i<10;i++){
			System.out.print(arr[i]);
		}
	}
}