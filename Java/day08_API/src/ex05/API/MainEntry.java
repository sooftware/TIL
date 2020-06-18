package ex05.API;

class Point{
	
}

public class MainEntry {
	public static void main(String[] args) {
		Point pt = new Point();
		System.out.println("Point pt information");
		System.out.println
		("class name : " + pt.getClass());	//	class의 내용을 알고 싶을 때
		System.out.println("hash code : " + pt.hashCode());		// 16진수들을 10진수로 보고 싶을 때 (주소)
		System.out.println("Object String : " + pt.toString());
		System.out.println("Object String : " + pt);
		System.out.println("===============================");
		
		Point pt2 = new Point();
		System.out.println("Point pt information");
		System.out.println("class name : " + pt2.getClass());	//	class의 내용을 알고 싶을 때
		System.out.println("hash code : " + pt2.hashCode());		// 16진수들을 10진수로 보고 싶을 때 (주소)
		System.out.println("Object String : " + pt2.toString());
		System.out.println("Object String : " + pt2);
		System.out.println("===============================");
		
		System.out.println("pt2.toString() : toString의 의미 " );
		System.out.println(pt2.getClass().getName() + '@' + Integer.toHexString(pt2.hashCode()));
		/* getClass.getName : 클래스의 내용중 클래스의 이름 */
		
		Point pt3 = new Point();	// 객체 생성, 메모리에 할당, 생성자함수 자동호출됨
		
		if(pt.hashCode() == pt3.hashCode()){
			System.out.println("같다");
		}
		else{
			System.out.println("다르다");
		}
		
		Point pt4;	// 객체 생성x, 메모리에 할당이 안됨
		pt4=pt;
		
		if(pt.hashCode() == pt4.hashCode()){
			System.out.println("같다");
		}
		else{
			System.out.println("다르다");
		}
	}
}
