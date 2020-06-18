package arr;
import java.util.*;

public class ArrayTest3 {
	public static void main(String[] args) {
		// 문제1] 특정달의 평균 강수량 구하는 프로그램 작성 (단,30일 기준)
		// 내가 임의로 비 올 확률은 20%로 설정
		// 비오는 양은 1~100까지로 랜덤 배정할 것
		int i=0;
		int NUM=30;
		double prob=0;
		int[]num = new int[NUM];
		int[] how_many= new int[NUM];
		int total=0;
		double average=0;
		
		for(i=0;i<NUM;i++){
			prob=Math.random();
			if(prob<=0.2){
				num[i]++;
				how_many[i]=(int)(Math.random()*100)+1;
			}
		}
		
		for(i=0;i<NUM;i++){
			if(num[i]==1){
				total+=how_many[i];
			}
		}
		average=total/(double)NUM;
		
		System.out.printf("이번 달의 강수량 평균은  %.2f입니다",average);
	}
}
