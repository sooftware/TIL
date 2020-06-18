package ex05.API;

class Circle{
	int x,y;
}

public class EqualsMethod {
	public static void main(String[] args) {
		Circle c1 = new Circle();
		Circle c2 = new Circle();
		
		System.out.println("c1 : " + c1.hashCode());
		System.out.println("c2 : " + c2.hashCode());
		
		if(c1==c2)	System.out.println("같다");
		else System.out.println("다르다");
		
		int x=3,y=3;
		System.out.println("기본 자료형 비교");
		if(x==y){ System.out.println("같다"); }
		else{System.out.println("다르다");}
		
		System.out.println("참조 자료형 비교");
		String str1 = new String("korea");
		String str2 = new String("Korea");
		
		if(str1==str2) System.out.println("같다");
		else System.out.println("다르다");
		
		
		System.out.println("========equals========");
		System.out.println("참조 자료형 비교");
		if(str1.equals(str2)){
			System.out.println("같다");
		}
		else{
			System.out.println("다르다");
		}
		
		System.out.println("=========equals(대,소문자 구분x)==========");
		System.out.println("참조 자료형 비교");
		if(str1.equalsIgnoreCase(str2)){
			System.out.println("같다");
		}
		else{
			System.out.println("다르다");
		}
	}
}
