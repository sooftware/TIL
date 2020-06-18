package method;

import java.util.*;

class Grade{
	/////////////////////////////////////////////
	public static void input(char[][] NAME,int[][] gwamok){
		int i=0,j=0,k=0;
		Scanner sc = new Scanner(System.in);
		String buffer=null;
		
		for(i=0;i<7;i++){
			System.out.print("학생"+(i+1)+"의 이름을 입력하세요 : ");
			buffer=sc.next();
			for(k=0;k<buffer.length();k++){
				NAME[i][k]=buffer.charAt(k);
			}
		}
		
		for(i=0;i<3;i++){
			for(j=0;j<7;j++){
				if(i==0){
					System.out.print("학생 "+(j+1)+"의 과목"+(i+1)+"의 점수를 입력하세요 : ");
					gwamok[i][j]=sc.nextInt();
				}
				if(i==1){
					System.out.print("학생 "+(j+1)+"의 과목"+(i+1)+"의 점수를 입력하세요 : ");
					gwamok[i][j]=sc.nextInt();
				}
				if(i==2){
					System.out.print("학생 "+(j+1)+"의 과목"+(i+1)+"의 점수를 입력하세요 : ");
					gwamok[i][j]=sc.nextInt();
				}
			}
			System.out.println("");
		}
	}
	
	///////////////////////////////////////////////
	public static void grade(int[][] gwamok,char[][] grade){
		int i=0,j=0;
		
		for(i=0;i<3;i++){
			for(j=0;j<7;j++){
					if(gwamok[i][j]< 101 && gwamok[i][j]>89){
						grade[i][j]='A';
					}
					if(gwamok[i][j]< 90 && gwamok[i][j]>69){
						grade[i][j]='B';
					}
					if(gwamok[i][j]< 70 && gwamok[i][j]>49){
						grade[i][j]='C';
					}
					if(gwamok[i][j]< 50){
						grade[i][j]='F';
					}
			}
		}
	}
	
	////////////////////////////////////////////////
	public static void output(char[][] NAME,char[][] grade){
		int i=0,j=0,k=0;
		for(j=0;j<7;j++){
			for(i=0;i<3;i++){
				for(k=0;k<NAME[j].length;k++){
					System.out.print(NAME[j][k]);
				}
				System.out.println("학생의 과목"+(i+1)+"의 학점은 "+grade[i][j]+"입니다");
			}
			System.out.println("=========================");
		}
	}
}

public class DivdeFunction {
	public static void main(String[] args) {
		int[][] gwamok=new int[3][7];
		char[][] grade=new char[3][7];
		char[][] NAME=new char[7][10];
		
		Grade.input(NAME,gwamok);
		Grade.grade(gwamok,grade);
		Grade.output(NAME,grade);
	}
}
