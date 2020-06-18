package java_finalExam;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;

public class HashMapEx {
	public static void main(String[] args) {
		HashMap<String,String> hm = new HashMap<String,String>();
		int i=1;
		
		hm.put("apple", "사과");
		hm.put("banana", "바나나");
		hm.put("grape", "포도");
		hm.put("pineapple", "파인애플");
		
		Set<String> keys = hm.keySet();
		Iterator<String> it = keys.iterator();
		
		while(it.hasNext()){
			String key = it.next();
			String val = hm.get(key);
			System.out.println(i+"번째 key : "+key +"\n"+i+"번째 value : "+val);
			i++;
		}	
	}
}
