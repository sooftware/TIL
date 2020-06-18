package java_finalExam;

import java.util.StringTokenizer;

public class P381 {
	public static void main(String[] args) {
		StringTokenizer st = new StringTokenizer("a=3,b=5,c=4","=,");
		int sum=0;
		int count=0;
		while(st.hasMoreTokens()){
			String str=st.nextToken();
			if(count%2==1){
				sum+=Integer.parseInt(str);
			}
			System.out.println(str);
			count++;
		}
		System.out.println("гую╨ : " + sum);
	}
}
