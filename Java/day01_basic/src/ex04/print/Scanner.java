//*
package ex04.print;

public class Scanner {
	public static void main(String[] args) {
		int kor=90,eng=88,com=100;
		int total=0;
		double average=0;
		String Name="KimSooHwan";
	
		
		
		total=kor+eng+com;
		average=total/3.0;
		
		System.out.println(Name);
		System.out.println("kor = " + kor + "\n" + "eng = " + eng + "\n" +"com = " + com);
		System.out.println("total =" + total);
		System.out.printf("average = %4.2f",average);
	}
}
//*/

/*
package ex04.print;

public class Scanner {
	public static void main(String[] args) {
		int kor=90,eng=88,com=100;
		int total=0;
		double average=0;
		String Name="KimSooHwan";
		
		total=kor+eng+com;
		average=total/3;
		
		System.out.println(Name);
		System.out.println("kor = " + kor + "\n" + "eng = " + eng + "\n" +"com = " + com);
		System.out.println("total =" + total);
		System.out.printf("average = %4.2f",average);
	}
}
//*/