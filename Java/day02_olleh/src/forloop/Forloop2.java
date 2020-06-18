package forloop;

public class Forloop2 {
	public static void main(String[] args) {
		int i=0,j=0;
		
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
		
		for(i=0;i<5;i++){
			for(j=0;j<=i;j++){
				System.out.print("*");
			}
			for(j=0;j<8-2*i;j++){
				System.out.print(" ");
			}
			for(j=0;j<=i;j++){
				System.out.print("*");
			}
			System.out.println("");
		}
		for(i=1;i<5;i++){
			for(j=5;j>i;j--){
				System.out.print("*");
			}
			for(j=0;j<2*i;j++){
				System.out.print(" ");
			}
			for(j=5;j>i;j--){
				System.out.print("*");
			}
			System.out.println("");
		}
	}
}
