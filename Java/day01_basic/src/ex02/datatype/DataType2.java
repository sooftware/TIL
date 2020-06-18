package ex02.datatype;

public class DataType2 {
	public static void main(String[] args) {
		String str = "A";	// 문자열, " ", 2byte -> A\0 
		char ch = 'A';	// 문자 , ' ', 1byte 
		char ch2=67; // 아스키코드값 67에 해당하는 문자로 들어간다
		int su=20;
		String aa="Happy"; // 자바는 c언어와 다르게 문자열 data type이 존재한다
		double d=12.345;
		
		System.out.println((int)ch); // 형변환 하는법 c언어랑 같음
		System.out.println(ch2);
		System.out.println(su);
		System.out.println(aa);
		System.out.println(str);
		System.out.println(d);
		System.out.println(ch+ch2); // 132로 연산이 된다
		System.out.println(ch + "," + ch2); // A,C로 분리되어 나온다
		
		for(int i=65;i<=90;i++){
			System.out.println((char)i);
		}
		
		System.out.println("\n\n boolean type");
		boolean flag=true;
		System.out.println(flag);
	
	}
}
