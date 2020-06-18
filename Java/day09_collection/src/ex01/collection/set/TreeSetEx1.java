package ex01.collection.set;
import java.util.*;

public class TreeSetEx1 {
	public static void main(String[] args) {
		TreeSet set = new TreeSet();
		int[] score = { 85,95,80,60,70,10,90,93 };
		
		for(int i=0;i<score.length;i++){
			set.add(new Integer(score[i]));
		}
		System.out.println(set);	// 자동으로 정렬한다.
		
		System.out.println("50보다 작은 값 : " + set.headSet(new Integer(50)));
		System.out.println("50보다 큰 값 : " + set.tailSet(new Integer(50)));
	}
}
