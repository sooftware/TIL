package forloop;
import java.util.*;

public class Calendar {
	public static void main(String[] args) {
		int day=0;
		int month;
		Scanner sc = new Scanner(System.in);
		
		System.out.print("INPUT MONTH : ");
		month=sc.nextInt();
		
		switch(month){
		case 1:
			day=31;
			break;
		case 2:
			day=28;
			break;
		case 3:
			day=31;
			break;
		case 4:
			day=30;
			break;
		case 5:
			day=31;
			break;
		case 6:
			day=30;
			break;
		case 7:
			day=31;
			break;
		case 8:
			day=31;
			break;
		case 9:
			day=30;
			break;
		case 10:
			day=31;
			break;
		case 11:
			day=30;
			break;
		case 12:
			day=31;
			break;
		default:
			System.out.println("FAIL");
			break;
		}
		
		System.out.println("입력하신 달은 " + day + "일 까지 있습니다");
	}
}
