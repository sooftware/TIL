package ArrayList;
import java.util.*;

public class Parking {
	protected int customer_number;
	protected int chargePerHour;
	Scanner sc = new Scanner(System.in);
	
	protected Parking(){
		customer_number=1;
		chargePerHour=5000;
	}
	
	/* 입차시간 입력 */
	protected void IN(LinkedList INLIST){
		int number=0;
		INLIST.add(customer_number);
		do{
			System.out.print(customer_number + "번 고객님의 들어온 시간을 입력해주세요 (example : 12시 30분 -> 12(내림으로 입력)) : ");
			number=sc.nextInt();
		}while(number<0 || number>24);
		INLIST.add(number);
		customer_number++;
	}
	/* 입차시간 입력 */

	
	/* 출차시간 입력 */
	protected int OUT(LinkedList OUTLIST){
		int number=0;
		boolean False=false;
		do{
			if(False){
				System.out.println("해당 고객번호는 존재하지 않습니다!");
				False=false;
			}
			System.out.print("몇 번 고객님의 출차 시간을 입력하시겠습니까?? : ");
			number=sc.nextInt();
			False=true;
		}while(number>customer_number || customer_number<0);
		OUTLIST.add(number);
		System.out.print(number + "고객님의 나간 시간을 입력해주세요 (example : 12시 30분 -> 13(올림으로 입력)) : ");
		OUTLIST.add(sc.nextInt());
		
		return number;
	}	
	/* 출차시간 입력 */
	
	/* 요금계산 */
	protected void calculate_charge(LinkedList INLIST,LinkedList OUTLIST,LinkedList CALCULATELIST){
		int charge=0;
		int number=0;
		int in_time=0;
		
		number=OUT(OUTLIST);
		for(int i=0;i<OUTLIST.size();i+=2){
			if(number==(int)INLIST.get(i)){
				number=(int)INLIST.get(i);
				in_time=(int)INLIST.get(i+1);
			}
		}
		
		for(int i=0;i<OUTLIST.size();i+=2){
				if(number==(int)OUTLIST.get(i)){
					CALCULATELIST.add(INLIST.get(i));	// 고객번호부터 추가
					charge=((int)OUTLIST.get(i+1) - in_time)*chargePerHour;	// (출차시간 - 입차시간) x 시간당 비용
					CALCULATELIST.add(charge);		// 비용추가
					System.out.println(number+"번 고객님의 요금은 " + charge + "원 입니다.");
					return;
				}
		}
	}
	/* 요금계산 */
	
	
	/* 고객리스트 삭제 */
	protected void remove_list(LinkedList INLIST,LinkedList OUTLIST,LinkedList CALCULATELIST){
		int number=0;
		
		System.out.print("몇번 고객님들 삭제하시겠습니까?? : ");
		number=sc.nextInt();
		
		/* INLIST 삭제 */
		for(int i=0;i<INLIST.size();i+=2){
			if((int)INLIST.get(i)==number){
				for(int j=0;j<2;j++){
					INLIST.remove(i);
				}
				break;
			}
		}
		
		/* OUTLIST 삭제 */
		for(int i=0;i<OUTLIST.size();i+=2){
			if((int)OUTLIST.get(i)==number){
				for(int j=0;j<2;j++){
					OUTLIST.remove(i);
				 }
				 break;
			}
		}
		
		/* CALCULATELIST 삭제 */
		for(int i=0;i<CALCULATELIST.size();i+=2){
			if((int)CALCULATELIST.get(i)==number){
				for(int j=0;j<2;j++){
					CALCULATELIST.remove(i);
				}
			}
		}
	}
	
	/* 고객리스트 삭제 */
	
	/*  고객리스트 출력 */
	protected void display(LinkedList INLIST,LinkedList OUTLIST,LinkedList CALCULATELIST){
		boolean out=false;		// 출력하려는 고객이 나갔으면 true 아니면 false
		int out_customer_number=0;
		int cal_customer_number=0;
		System.out.println("====================================");
		System.out.println("Welcome to Soo-Hwan`s Parking Management Program");
		System.out.println("====================================\n\n");
		
		System.out.println("오늘 총 " +( customer_number-1 ) +"명의 고객님들께서 주차관리 시스템을 이용해주셨습니다.");
		
		for(int i=0;i<INLIST.size();i+=2){
			/* out인지 아닌지 판별 */
			for(int j=0;j<OUTLIST.size();j+=2){
				/* INLIST에 해당하는 고객번호의 정보를 OUTLIST에서 찾는다 */
				if(INLIST.get(i)==OUTLIST.get(j)){
					out=true;
					out_customer_number=j;
					/* INLIST에 해당하는 고객번호의 정보를 CALCULATELIST에서 찾는다*/
					for(int k=0;k<CALCULATELIST.size();k+=2){
						if(INLIST.get(i)==CALCULATELIST.get(k)){
							cal_customer_number=k;
						}
					}
					break;
				}
				else{
					out=false;
				}
			}
			
			/* 출력 */
			System.out.println("\n");
			System.out.println("==================================");
			if(out){
				System.out.println(INLIST.get(i)+"번 고객님의 정보");
				System.out.println("입차 시간 : " + INLIST.get(i+1));
				System.out.println("출차 시간 : " + OUTLIST.get(out_customer_number+1));
				System.out.println("부과된 요금 : " + CALCULATELIST.get(cal_customer_number+1));
			}
			else{
				System.out.println(INLIST.get(i)+"번 고객님의 정보");
				System.out.println("입차 시간 : " + INLIST.get(i+1));
				System.out.println("출차시간 : 아직 출차하지 않으셨습니다.");
				System.out.println("부과된 요금 : 아직 출차하지 않으셨습니다.");
			}
			System.out.println("==================================");
			/* 출력 */
		}
	}
	

	/* SET GET */
	
	
	protected int getCustomer_number() {
		return customer_number;
	}

	protected void setCustomer_number(int customer_number) {
		this.customer_number = customer_number;
	}

	protected int getChargePerHour() {
		return chargePerHour;
	}

	protected void setChargePerHour(int chargePerHour) {
		this.chargePerHour = chargePerHour;
	}
	
	/* SET GET */

}
