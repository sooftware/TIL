package ex06.random;
import java.util.*;

public class Lotto {
	public static void main(String[] args) {
		int num=7;
		int[] lotto_num = new int[num];		//1~45
		int[] user_num = new int[num];
		int count=0;
		boolean overlap=false;
		
		for(int i=0;i<num;i++){
			lotto_num[i] = (int)(Math.random() *45+1);
			for(int j=1;j<=i;j++){
				if(lotto_num[i]==lotto_num[j-1]){
					overlap=true;
				}
			}
			if(overlap){
				i--;
			}
			overlap=false;
		}
		
		for(int i=0;i<num;i++){
			user_num[i] = (int)(Math.random() *45+1);
			for(int j=1;j<=i;j++){
				if(user_num[i]==user_num[j-1]){
					overlap=true;
				}
			}
			if(overlap){
				i--;
			}
			overlap=false;
		}
		
		for(int i=0;i<num;i++){
			for(int j=0;j<num;j++){
				if(user_num[i]==lotto_num[j]){
					count++;
				}
			}
		}

		
		for(int i=0;i<num-1;i++){
			System.out.println("로또 당첨 " + (i+1) + "번째 번호 : " + lotto_num[i]);
		}
    	System.out.println("로또 당첨 행운의 번호 : " + lotto_num[num-1]);
    	
    	System.out.println("=====================");
    	
		for(int i=0;i<num-1;i++){
			System.out.println("유저 " + (i+1) + "번째 번호 : " + user_num[i]);
		}
    	System.out.println("유저 행운의 번호 : " + user_num[num-1]);
    	System.out.println("=====================");
    	System.out.println(count + "개의 숫자가 일치합니다");
	}
}
