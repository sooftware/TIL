package ManageParking;
import java.util.*;

/*
1. 주차시간
2. 출차시간
3. 요금정산
4. 수정
 */

public class Manage {
	public static void main(String[] args) {
		LinkedList list1= new LinkedList();
		LinkedList list2 = new LinkedList();
		LinkedList FinalList =new LinkedList();
		Parking pk = new Parking();
		Scanner sc = new Scanner(System.in);
		int select=0;
		int select_add=0;
		int i=0,j=0;
		while(true){
			select=pk.menu();
			/* 고객정보추가 */
			if(select==1){
				for(i=0;i<=j;i++){
					select_add=pk.add();
					if(select_add==1){
						pk.parking_time(list1);
					}else if(select_add==2){
						pk.out_time(list1, list2);
						pk.calculate_charge(list1, list2, FinalList);
					}
					else{
						System.out.println("잘못입력하셨습니다!!!");
						j++;
					}
				}
				/* 고객 정보 삭제 */
			}else if(select==2){
				pk.remove(FinalList);
				/* 고객 정보 수정 */
			}else if(select==3){
				pk.modify(list1,list2);
				pk.calculate_charge(list1, list2, FinalList);
			}else if(select==4){
				pk.display(FinalList);
			}else if(select==5){
				return;
			}
		}
		
	}
}


class Parking{
	Scanner sc = new Scanner(System.in);
	int num=0;
	int count=0;
	
	public int menu(){
		int select=0;
		
		System.out.println("\n\nWelcome to Soo-Hwan`s Parking Manager Program");
		System.out.println("=====SELECT MENU=====");
		System.out.println("1. 고객 정보 추가");
		System.out.println("2. 고객 정보 삭제");
		System.out.println("3. 고객 정보 수정");
		System.out.println("4. 고객 리스트 출력");
		System.out.println("5. 종료");
		System.out.println("====================");
		while(true){
			System.out.print("INPUT : ");
			select=sc.nextInt();
			
			if(select>0 && select<6){
				return select;
			}
			else{
				System.out.println("잘못 입력하셨습니다. 다시 입력해주세요.");
			}
		}
	}
	
	public int add(){
		int select=0;
		System.out.println("\n\n1. 주차시간 입력 \n");
		System.out.println("2. 출차시간 입력 ");
		select=sc.nextInt();
		
		return select;
	}
	
	public void parking_time(LinkedList list){
			count++;
			System.out.print("\n\n고객번호를 입력해주세요");
			list.add(sc.nextInt());
			System.out.print("들어온 hour을 입력해주세요 : ");
			list.add(sc.nextInt());
			System.out.print("들어온 minute을 입력해주세요  : ");
			list.add(sc.nextInt());
	}
	
	public void out_time(LinkedList list,LinkedList list2){	
			System.out.print("\n\n고객번호를 입력해주세요 : ");
			list2.add(sc.nextInt());
			System.out.print("나간 hour을 입력해주세요 : ");
			list2.add(sc.nextInt());
			System.out.print("나간 minute을 입력해주세요  : ");
			list2.add(sc.nextInt());
	}
	
	public void calculate_charge(LinkedList list,LinkedList list2,LinkedList FinalList){
		int gap_hour=0;
		int gap_minute=0;
		int charge=0;
		for(int i=0,j=0;i<list2.size()-2;i+=3){
			for(int k=0;k<list2.size()-2;k+=3){
				if(list.get(i)==list2.get(k)){
					gap_hour = (int)list2.get(i+1)-(int)list.get(i+1);
					gap_minute=(int)list2.get(i+2)-(int)list.get(i+2);
					charge=5000*gap_hour + 100*gap_minute;
					j++;

					FinalList.add(list.get(i));
					FinalList.add((int)list.get(i+1)*100+(int)list.get(i+2));
					FinalList.add((int)list2.get(i+1)*100+(int)list2.get(i+2));
					FinalList.add(charge);
				}
			}
		}
	}
	
	public void remove(LinkedList FinalList){
		int person_number=0;
		
		System.out.print("\n\n삭제하실 고객 번호를 입력해주세요 : ");
		person_number=sc.nextInt();
		
		for(int i=0;i<FinalList.size()-3;i+=3){
			if(person_number==(int)FinalList.get(i)){
				for(int j=0;j<4;j++){
					FinalList.remove(i);
				}
			}
		}
	}
	
	public void modify(LinkedList list1,LinkedList list2){
		int person_number=0;
		int select_mod=0;
		int time=0;
		int modify=0;
		System.out.print("\n\n수정하실 고객 번호를 입력해주세요 : ");
		person_number=sc.nextInt();
		System.out.println("1 : 들어온 시간 수정");
		System.out.println("2 : 나간 시간 수정");
		select_mod=sc.nextInt();
		System.out.print("수정할 시간 입력 : ");
		time=sc.nextInt();
		
		if(select_mod==1){
			for(int i=0;i<list1.size();i+=4){
				if(person_number==(int)list1.get(i)){
					list1.set(i+1,time);
				}
			}
		}else if(select_mod==2){
			for(int i=0;i<list2.size();i+=4){
				if(person_number==(int)list2.get(i)){
					list2.set(i+2,time);
				}
			}
		}
	}

	public void display(LinkedList FinalList){
		for(int i=0;i<FinalList.size()-3;i+=4){
			System.out.println("\n\n"+ FinalList.get(i) + "번 고객님의 정보");
			System.out.println("들어온 시간 : " + FinalList.get(i+1));
			System.out.println("나간 시간 : " + FinalList.get(i+2));
			System.out.println("부과된 요금 : " + FinalList.get(i+3));
		}
	}
}















