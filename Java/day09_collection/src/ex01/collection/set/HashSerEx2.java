package ex01.collection.set;
import java.util.*;

public class HashSerEx2 {
	public static void main(String[] args) {
		Object[] objArr = {"1",new Integer(1),"2","3","4","4","4"};
		
		Set set = new HashSet();		// 부모로부터 자손객체 생성 가능
		
		for(int i=0;i<objArr.length;i++){
			set.add(objArr[i]);
		}
		
		System.out.println("set : " + set);	// 자료형이 다른 1은 서로 다르게 인식한다.
	}
}
