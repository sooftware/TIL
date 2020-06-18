package java_finalExam;

import java.util.Scanner;

public class WrapperArray {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.print("ªÁ¿Ã¡Ó : ");
		int size = sc.nextInt();
		
		int array = makeArray(size);
		
	}
	
	public static int makeArray(int size){
		int[] newArray = new int[size];
		
		for(int i=0;i<size;i++){
			newArray[i]=i+1;
		}
		
		int a = Integer.parseInt(newArray.toString());
		System.out.println(a);
		System.out.println(newArray);
		
		return a;
	}
}
