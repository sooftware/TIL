package vectorEx1;
import java.util.*;

/* Vector´Â List´Ù!! */

public class VectorProblem {
	public static void main(String[] args) {
		int num=3;
		Vector<String> v = new Vector<String>(num,4);
		Scanner sc = new Scanner(System.in);
		Vector<String> v2 = new Vector<String>(num,4);
		
		
		for(int i=0;i<num;i++){
			System.out.print("INPUT NAME : ");
			v.add(sc.next());
		}
		for(int i=0;i<num;i++){
			System.out.println("NAME : " + v.elementAt(i));
		}
		
		for(int i=0;i<num;i++){
			System.out.print("INPUT NAME : ");
			v2.add(sc.next());
		}
		
		System.out.print("NAME : ");
		Iterator it = v2.iterator();
			while(it.hasNext()){
				System.out.print(it.next());
			}
	}
}
