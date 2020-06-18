package java_finalExam;

import java.util.Iterator;
import java.util.Vector;

public class IteratorEx {
	public static void main(String[] args) {
		Vector<Integer> v = new Vector<Integer>();
		Iterator<Integer> it = v.iterator();
		
		v.add(1);
		v.add(2);
		v.add(3);
		
		while(it.hasNext()){
			int n=it.next();
			System.out.println(n);
		}
	}
}
