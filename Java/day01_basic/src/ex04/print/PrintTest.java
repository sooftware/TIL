package ex04.print;

public class PrintTest {
	public static void main(String[] args) {
		double num=123.4567;
		
		System.out.println(num);
		System.out.printf("%f\n",num);
		System.out.printf("%f\n",35.6);
		System.out.printf("%f \t %d \t %c\n",77.77,100,'F');
		System.out.printf("%f\n",12.345678953); // 소수점 6자리 이상이면 7자리에서 반올림된다
		System.out.printf("%10.2f\n",12.3456
				
				78453); // %전체자리수.소수점자리수 (반올림)
		System.out.printf("%1.4f\n",12.3456789); // 1로 지정했어도 2자리 이므로 무시된다 
	}
}
