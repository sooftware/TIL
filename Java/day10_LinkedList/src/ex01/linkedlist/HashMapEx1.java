package ex01.linkedlist;
import java.util.*;

public class HashMapEx1 {
	public static void main(String[] args) {
		HashMap<String,Integer> map = new HashMap<>();
		map.put("kosta",1234);
		map.put("asdf",1111);
		map.put("asdf",1234);
		
		Set set = map.entrySet();
		Iterator it = set.iterator();
		
		while(it.hasNext()){
			Map.Entry e = (Map.Entry)it.next();
		}
	}
}
