package ex01.collection.set;
import java.util.*;

public class TreeSetEx2 {
	public static void main(String[] args) {
		Set set = new TreeSet();
		
		for(int i=0;i<6;i++){
			int num = (int)(Math.random()*45)+1;
			set.add(new Integer(num));
		}
		
		System.out.println(set);
	}
}
