import java.util.ArrayList;
import java.util.Scanner;

public class test {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		ArrayList list = new ArrayList();
		
		for (int i = 0; i < 73; i++) {
			Dsp dsp = new Dsp();
			System.out.println(i+1+"===============");
			System.out.print("학번 : ");
			dsp.stdno = sc.next();
			System.out.print("중간 : ");
			dsp.mid_exam = sc.nextDouble();
			System.out.print("기말 : ");
			dsp.final_exam = sc.nextDouble();
			System.out.println("===============");
			dsp.score = (dsp.mid_exam/(10.4))
											+ (dsp.final_exam/18);
			list.add(dsp);
		}
		
		String stdno;
		int index = 0;
		double score = 0 ;
		int rank=1;
		do {
			System.out.print("확인할 학번");
			stdno = sc.next();
			
			for(int i=0;i<73;i++) {
				Dsp dsp = (Dsp) list.get(i);
				if(dsp.stdno.equals(stdno)) {
					index = i;
					break;
				}
			}
			
			Dsp ds = (Dsp) list.get(index);
			score = ds.score;
			for(int i=0;i<73;i++) {
				Dsp dsp = (Dsp) list.get(i);
				if(score <= dsp.score) {
					rank++;
				}
			}
			
		}while(true);
	}
	
}

class Dsp {
	String stdno;
	double mid_exam;
	double final_exam;
	double score;
	
	
}