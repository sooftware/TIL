package forloop;

public class Forloop {
	public static void main(String[] args) {
		int i=0,j=0;;
		
		for(i=0;i<5;i++){
			for(j=0;j<=i;j++){
				System.out.print("*");
			}
			System.out.println("");
		}
		
		for(i=0;i<4;i++){
			for(j=4;j>i;j--){
				System.out.print("*");
			}
			System.out.println("");
		}
		
		for(i=0;i<5;i++){
			for(j=4;j>i;j--){
				System.out.print(" ");
			}
			for(j=0;j<=i;j++){
				System.out.print("*");
			}
			System.out.println("");
		}

		for(i=0;i<4;i++){
			for(j=0;j<=i;j++){
				System.out.print(" ");
			}
			for(j=4;j>i;j--){
				System.out.print("*");
			}
			System.out.println("");
		}
	}
}
