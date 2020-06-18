package Test1;

import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;

public class Test {
	private int a, b;

	public static void main(String[] args) {
		LinkedList list = new LinkedList();
		HashSet set = new HashSet();
		Iterator it;
		
		for (int i = 0; i < 10; i++) {
		//	list.add(i);
			set.add(i);
		}
		
		it = set.iterator();
		
		while(it.hasNext()) {
		//	System.out.println(list.get(i));
			System.out.println(it.next());
		}
	}

}
