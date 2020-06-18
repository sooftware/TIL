package iterator;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;

public class IteratorEx {
	public static void main(String[] args) {
		HashMap<String,String> map = new HashMap();
		Set<String> key = map.keySet();
		
		
		map.put("key1", "value1");
		map.put("key2", "value2");
		map.put("key3", "value3");
		
		Iterator<String> it = key.iterator();
		
		while(it.hasNext()){
			String keys=it.next();
			System.out.println("###########");
			System.out.println("KEY : " + keys);
			System.out.println("Value : " + map.get(keys));
		}
		System.out.println("###########");
	}
}
