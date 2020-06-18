package vectorEx1;
import java.util.*;

public class VectorEx1 {

	public static void main(String[] args) {
		Vector<Integer> v = new Vector<Integer>();
		System.out.println("length            |              capacity");
		int len = v.size();
		System.out.println(len + "                      |                    " + v.capacity()); 	// 0,10
		
		System.out.println("==========================");
		
		Vector<Integer> v2 = new Vector<Integer>(3,4);	// 3개를 초기 사이즈로 지정하고 넘칠때마다 +4씩 하겠다
		v2.add(2);
		v2.add(new Integer(333));
		v2.add(2);
		len = v2.size();
		System.out.println("length            |              capacity");
		System.out.println(len + "                      |                    " + v2.capacity()); 	// 0,10
		
		System.out.println("==========================");
		
		v2.add(20);		v2.add(12);		v2.add(55);		v2.add(20);		v2.add(89);			v2.add(99);
		len = v2.size();
		System.out.println("length            |              capacity");
		System.out.println(len + "                      |                    " + v2.capacity()); 	// 0,10
		
		System.out.println("==========Iterator Method===========");
		
		Iterator it = v2.iterator();
		while(it.hasNext()){
			System.out.print(it.next() + "\t");
		}
		
		System.out.println("\n==========elementsAt() Method===========");
		for(int i=0;i<v2.size();i++){	//	vector에 있는 모든 요소에 대해 반복
			Integer num = v2.elementAt(i);
			System.out.print(num.toString() +  "\t");
		}
		
		System.out.println("\n==========get() Method===========");
		for(int i=0;i<v2.size();i++){
			System.out.print(v2.get(i) + "\t");
		}
		
		System.out.println("\n==========sort result===========");
		Collections.sort(v2);
		for(int i=0;i<v2.size();i++){
			System.out.print(v2.get(i) + "\t");
		}
		
		System.out.println("\n==========trimToSize() method===========");
		System.out.println("length            |              capacity");
		System.out.println(v2.size() + "                  |                     " + v2.capacity());
		v2.trimToSize();
		System.out.println(v2.size() + "                  |                     " + v2.capacity());
		
		System.out.println("=======================");
		Vector<Integer> v3 = new Vector<Integer>();
		v3.add(2);	v3.add(new Integer(333));	v3.add(22);
		System.out.println("length            |              capacity");
		System.out.println(v3.size() + "                  |                     " + v3.capacity());
		}

}
