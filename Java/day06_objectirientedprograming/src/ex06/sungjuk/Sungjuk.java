package ex06.sungjuk;
import java.util.*;

public class Sungjuk {
	Scanner sc = new Scanner(System.in);
	protected int[][] score = new int[3][3];	
	protected String[] name = new String[3];
	
	public Sungjuk(){
		for(int i=0;i<3;i++){
			System.out.print("INPUT " + (i+1) + " NAME : ");
			name[i]=sc.next();
			System.out.print("INPUT KOR SCORE : ");
			score[i][0]=sc.nextInt();
			System.out.print("INPUT ENG SCORE : ");
			score[i][1]=sc.nextInt();
			System.out.print("INPUT COM SCORE : ");
			score[i][2]=sc.nextInt();
		}
	}
	

	/* SET GET */
	
	public int[][] getScore() {
		return score;
	}

	public void setScore(int[][] score) {
		this.score = score;
	}

	public String[] getName() {
		return name;
	}

	public void setName(String[] name) {
		this.name = name;
	}



	/* SET GET */
}

class Grade extends Sungjuk{
	protected int[] total = new int[3];
	protected double[] average = new double[3];
	protected char[][] grade = new char[3][3];
	
	public Grade(){
		for(int i=0;i<3;i++){
			for(int j=0;j<3;j++){
				total[i] += score[i][j];
			}
			average[i]=total[i] / (3.0);
		}
		
		for(int i=0;i<3;i++){
			for(int j=0;j<3;j++){
				if(score[i][j] > 89 &&  score[i][j] <101){
					grade[i][j]='A';
				}
				else if(score[i][j] > 69 && score[i][j] < 90){
					grade[i][j]='B';
				}
				else if(score[i][j] > 49 && score[i][j] < 70){
					grade[i][j]='C';
				}
				else if(score[i][j] < 50){
					grade[i][j]='F';
				}
			}
		}
		
	}
	
	/* SET GET */

	public int[] getTotal() {
		return total;
	}

	public void setTotal(int[] total) {
		this.total = total;
	}

	public double[] getAverage() {
		return average;
	}

	public void setAverage(double[] average) {
		this.average = average;
	}

	public char[][] getGrade() {
		return grade;
	}

	public void setGrade(char[][] grade) {
		
		this.grade = grade;
	}

	/* SET GET */
}

class Output extends Grade{
	public void display(){
		System.out.println("===============================");
		for(int i=0;i<3;i++){
			for(int j=0;j<3;j++){
				if(j==0){
					System.out.println(name[i] + "의 kor과목은 " + grade[i][j] + "입니다");
				}
				else if(j==1){
					System.out.println(name[i] + "의 eng과목은 " + grade[i][j] + "입니다");
				}
				else if(j==2){
					System.out.println(name[i] + "의 com과목은 " + grade[i][j] + "입니다");
				}
			}
			System.out.printf("%s의 총 점수는 %d이고 평균 점수는 %.2f입니다.\n",name[i],total[i],average[i]);
			System.out.println("===============================");
		}
	}
}