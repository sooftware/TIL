package forloop;
import java.util.*;

public class Three {
	public static void main(String[] args) {
		int dan=0;
		Scanner sc = new Scanner(System.in);
		
		for(int j=0;j<3;j++){
			System.out.print("¸î ´Ü ? : ");
			dan=sc.nextInt();
			
			switch(dan){
			case 3:
				for(int i=1;i<10;i++){
					System.out.println(dan + "x" + i + "=" + dan*i );
				}
				break;
			case 6:
				for(int i=1;i<10;i++){
					System.out.println(dan + "x" + i + "=" + dan*i );
				}
				break;
			case 9:
				for(int i=1;i<10;i++){
					System.out.println(dan + "x" + i + "=" + dan*i );
				}
				break;
			default:
				System.out.println("FAIL");
				break;
			}
		}
	}
}
