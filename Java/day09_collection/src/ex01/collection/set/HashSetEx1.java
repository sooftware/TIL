package ex01.collection.set;
import java.util.*;

/* Set : 순서없고, 중복 허용 x */
public class HashSetEx1 {
	public static void main(String[] args) {
		HashSet<String> hs = new HashSet<String>();		// String으로만 저장할거야! 라는 의미 즉, <>는 type 제한
		 
		hs.add("김수환무");
		hs.add("킴");
		hs.add("솬킴");
		hs.add("김수환");
		hs.add("킴");
		
		HashSet<Integer> hs2 = new HashSet<Integer>();		// type제한을 둘떄는 기본 자료형이 아닌 class 자료형으로 제한을 둬야 한다
		hs2.add(200);
		hs2.add(100);
		hs2.add(30);
		
		Iterator it2 = hs2.iterator();
		
		while(it2.hasNext()){
			System.out.println(it2.next());
		}
		System.out.println("=================");
		
		System.out.println("요소 개수 : " + hs.size());		// set은 중복이 되지 않기때문에 "킴"은 한번만 저장된다
		
		Iterator it = hs.iterator();
		while(it.hasNext()){		// 다음 요소가 있다면
			System.out.println(it.next()); 	// 요소를 꺼내와서 출력함	, set은 순서가 없기 때문에 순서는 임의로 배정되서 나온다.
		}
		
		System.out.println("=================");
		for(Object item : hs){
			System.out.println(item);
		}
	}
}
