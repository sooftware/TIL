package ex02.Util;
import java.util.*;

public class DateEX03 {
	public static void main(String[] args) {
		Calendar c = Calendar.getInstance();	// Calendar는 객체 생성이 불가하기 때문에 이런 식으로
																				// system이 갖고 있는 날짜 얻어옴
		System.out.println(c.get(Calendar.YEAR) + "년");
		System.out.println((c.get(Calendar.MONTH)+1) + "월");	// MONTH는 0부터 시작하기때문에 +1을 해주어야 한다
		System.out.println(c.get(Calendar.DATE) + "일");
		System.out.println("===================");
		
		Date date = new Date();
		int h = date.getHours();
		int m = date.getMinutes();
		int s = date.getSeconds();
		System.out.println("현재시간은 " + h  +" 시 " + m + "분" + s +  "초 입니다." );
		
		Calendar c1 = Calendar.getInstance();
		Calendar c2 = Calendar.getInstance();
		
		c2.set(2017, 12,20,0,0);
		
		if(c1.after(c2)){
			System.out.println("현재 시간은 2017년 1월 1일 이후입니다.");
		}
		else if(c1.before(c2)){
			System.out.println("현재 시간은 2017년 1월 1일 이전입니다.");
		}
		else if(c1.equals(c2)){
			System.out.println("현재 시간은 2017년 1월 1일 입니다.");
		}
	}
}
