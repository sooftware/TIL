package practicelinkedlist;
import java.util.*;

public class LinkedListPractice {
	Scanner sc = new Scanner(System.in);
	LinkedListPractice lp ;
	
	/* SET GET */
	
	public Scanner getSc() {
		return sc;
	}

	public void setSc(Scanner sc) {
		this.sc = sc;
	}

	public LinkedListPractice getLp() {
		return lp;
	}

	public void setLp(LinkedListPractice lp) {
		this.lp = lp;
	}

	/* SET GET */
	
	public int menu(){
		int select=0;
		
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
	
	public void add(LinkedList list){
		System.out.print("고객이름 : "); 
		list.add(sc.next());
		System.out.print("비디오 제목 : ");
		list.add(sc.next());
		System.out.print("비디오 장르 : ");
		list.add(sc.next());
		System.out.print("대여 날짜 : ");
		list.add(sc.next());
	}
	
	public void remove(LinkedList list){
		System.out.print("삭제할 고객 이름 : ");
		String name = sc.next();
		int index=0;
		for(int i=0;i<list.size();i++){
			if(name.equals(list.get(i))){
				System.out.println(name);
				for(int j=0;j<4;j++){
					list.remove(i);
				}
			}
		}
	}
	
	public void modify(LinkedList list){
		System.out.print("수정을 원하는 내용 : ");
		String buffer = sc.next();
		System.out.print("수정할 내용 : ");
		String mod = sc.next();
		
		for(int i=0;i<list.size();i++){
			if(buffer.equals(list.get(i))){
				list.set(i, mod);
				break;
			}
		}
	}
	
	public void display(LinkedList list){
		int count=1;
		System.out.println("\n\n====고객리스트====\n\n");
		for(int i=0;i<list.size();i+=4){
			System.out.println(count + "번째 고객");
			System.out.println("고객이름 : " + list.get(i));
			System.out.println("비디오제목 : " + list.get(i+1));
			System.out.println("비디오장르 : " + list.get(i+2));
			System.out.println("대여날짜 : " + list.get(i+3));
			System.out.println("----------------------------------------------");
			count++;
		}
		System.out.println("\n\n");
	}
}
