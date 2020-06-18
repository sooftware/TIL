package forloop;

public class OneTwoThreeFourBubbleBubble {
	public static void main(String[] args) {
		int i=0,j=0,buf=0;
		int[] arr={1,2,3,4,5,6,7,8,9,10};
		
		System.out.println("Before");
		for(i=0;i<10;i++){
			System.out.print(arr[i]+" ");
		}
		System.out.println("");
		
		for(i=0;i<9;i++){
			for(j=0;j<9;j++){
				if(arr[j]<arr[j+1]){
					buf=arr[j];
					arr[j]=arr[j+1];
					arr[j+1]=buf;
				}
			}
		}
		
		System.out.println("After");
		for(i=0;i<10;i++){
			System.out.print(arr[i]+" ");
		}
	}
}
