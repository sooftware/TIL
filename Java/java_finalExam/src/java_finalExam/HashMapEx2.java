package java_finalExam;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Scanner;
import java.util.Set;

public class HashMapEx2 {
	public static void main(String[] args) {
		HashMap<String,String> hm = new HashMap<String,String>();
		Scanner sc = new Scanner(System.in);
		
		hm.put("kim", "김수환");
		hm.put("park", "박재모");
		hm.put("jo", "조윤성");
		hm.put("ha", "하용조");
		
		System.out.print("찾고싶은 성 영어로 쳐 : ");
		String find = sc.next();
		
		Set<String> keys = hm.keySet();
		Iterator<String> it = keys.iterator();
		while(it.hasNext()){
			String str = it.next();
			if(str.equals(find)){
				String value = hm.get(find);
				System.out.println(value);
			}
		}
	}
}
