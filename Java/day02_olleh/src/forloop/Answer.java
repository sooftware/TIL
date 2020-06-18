package forloop;
import java.util.*;

public class Answer {
	public static void main(String[] args) {
		// 3개 입력받아서 평균 60점 이상이여야 하고, 
		// 각 과목 과락은 40점이하면 과목 불합격
		int kor=0,eng=0,com=0;
		boolean pass1,pass2;
		boolean kor_pass,eng_pass,com_pass;
		double avg=0;
		Scanner sc = new Scanner(System.in);
		
		System.out.print("KOR : ");
		kor=sc.nextInt();
		System.out.print("ENG : ");
		eng=sc.nextInt();
		System.out.print("COM : ");
		com=sc.nextInt();
		
		avg=(kor+eng+com)/3.0;
		
		if(avg>=60){
			pass1=true;
		}
		else{
			pass1=false;
		}
		
		if(kor>=40){
			pass2=true;
			kor_pass=true;
		}
		else{
			pass2=false;
			kor_pass=false;
		}
		if(eng>=40){
			pass2=true;
			eng_pass=true;
		}
		else{
			pass2=false;
			eng_pass=false;
		}
		if(com>=40){
			pass2=true;
			com_pass=true;
		}
		else{
			pass2=false;
			com_pass=false;
		}
		
		if(pass1 && pass2){
			System.out.println("합격");
		}
		else{
			if(avg>=60){
				if(kor_pass==false){
					System.out.print("국어 과락 ");
				}
				if(eng_pass==false){
					System.out.print("영어 과락 ");
				}
				if(com_pass==false){
					System.out.print("전산 과락 ");
				}
				System.out.println("으로 인한 불합격");
			}
			else{
				System.out.println("평균 미달로 인한 불합격");
				if(kor_pass==false){
					System.out.print("국어 과락 ");
				}
				if(eng_pass==false){
					System.out.print("영어 과락 ");
				}
				if(com_pass==false){
					System.out.print("전산 과락 ");
				}
			}
		}
	}
}
