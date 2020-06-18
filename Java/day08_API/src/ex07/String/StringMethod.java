package ex07.String;

public class StringMethod {
	public static void main(String[] args) {
		String s1 = "KimSooHwan";
		String s2 = "CHEON-AN";
		
		System.out.println(s1);
		System.out.println(s2);
		System.out.println("s1의 주소 : " + s1.hashCode() + "s2의 주소 :" + s2.hashCode());
		System.out.println("replace : " + s2.replace("EO","eo"));
		System.out.println("replace는 출력할 때만 변경하지 String자체를 바꾸지 않습니다");
		System.out.println("non-replace : " + s2);
		
		String s3 = new String("               ab             cd              ef              gh         ij        ");
		System.out.println(s3);
		System.out.println("s3 length = " + s3.length());
		System.out.println(s3.trim());
		
		int[] arr = {1,2,3,4,5};
		for(int i=0;i<arr.length;i++){
			System.out.println(arr[i] +  "\t");
		}
		System.out.println("====================");
		
		String s4 = new String("ab/cde fegrag/352341/far g/fa   ergae/raa  erh");
		String[] s5 = s4.split("/"); 	// split자체가 배열을 return 받음
		for(int i=0;i<s5.length;i++){
			System.out.println("분리된 " + i + "번째 문자열 : " + s5[i]);
		}
		
		String s6 = new String("010-4564-4668");
		String[] s7 = s6.split("-");
		for(int i=0;i<s7.length;i++){
			System.out.println(s7[i]);
		}
		
		System.out.println("=========================");
		
		String s8 = "1231f53ae1g5ar5g1rae";
		char ch = s8.charAt(10);
		System.out.println(ch);
		
		s8 = s8.substring(3);
		System.out.println(s8);// 3번 인덱스부터 끝까지 출력
		System.out.println("=================");
		
		s8 = s8.substring(5, 7);
		System.out.println(s8);
		
		s8 = "1234567890abcdef 34566 789d999 string";
		System.out.println(s8.indexOf('d'));
		System.out.println(s8.lastIndexOf('d'));
	}
}