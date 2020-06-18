package practicelinkedlist;
import java.util.*;

public class MainEntry {
	public static void main(String[] args) {
		LinkedListPractice LP = new LinkedListPractice();
		LinkedList<LinkedListPractice> list = new LinkedList<LinkedListPractice>();
		int select=0;
		
		while(true){
			select=LP.menu();
			if(select==1){
				LP.add(list);
			}else if(select==2){
				LP.remove(list);
			}else if(select==3){
				LP.modify(list);
			}else if(select==4){
				LP.display(list);
			}else if(select==5){
				return;
			}
		}
	}
}
