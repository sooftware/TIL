package ex08.Problem;
import java.util.*;
import java.io.*;

public class Person {
	Scanner sc = new Scanner(System.in);
	protected String name;
	protected String age;
	protected String sex;
	LinkedList student = new LinkedList();
	LinkedList non_student = new LinkedList();
	
	/* SET GET */
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getAge() {
		return age;
	}
	public void setAge(String age) {
		this.age = age;
	}
	public String getSex() {
		return sex;
	}
	public void setSex(String sex) {
		this.sex = sex;
	}
	

	
	/* SET GET */
}

class Student extends Person{
	protected String major;
	protected String Student_number;
	protected String grade;
	protected String score;
	protected int number_of_student;
	protected int number_of_nonstudent;
	protected boolean if_student=true;
	
	protected void input(){
		String student=null;
		char mode =' ';
		
		System.out.println("===========================");
		System.out.println("Welcome to SooHwan`s Program");
		System.out.println("===========================\n\n");
		
		System.out.print("NAME : ");
		name=sc.next();
		System.out.print("A¤»¤±1¤µGE : ");
		age=sc.next();
		System.out.print("SEX : ");
		sex=sc.next();
		
		System.out.print("are you student??? (y/n) ");
		student=sc.next();
		mode=student.charAt(0);
		switch(mode){
		case 'y' :  case 'Y' :
			
			if_student=true;
			number_of_student++;
			
			
			System.out.print("MAJOR : ");
			major=sc.next();
			System.out.print("STUDENT NUMBER : ");
			Student_number=sc.next();
			System.out.print("GRADE : ");
			grade=sc.next();
			System.out.print("SCORE : ");
			score=sc.next();
			System.out.println("Thank you.");
			break;
		case 'n' : case 'N' :
			if_student=false;
			number_of_nonstudent++;
			System.out.println("Thank you.");
			break;
		default:
			break;
		}
	}

	protected void list(LinkedList non_student,LinkedList student){
		if(if_student){
			student.add(name);
			student.add(age);
			student.add(sex);
			student.add(major);
			student.add(Student_number);
			student.add(grade);
			student.add(score);
		}
		else{
			non_student.add(name);
			non_student.add(age);
			non_student.add(sex);
		}
	}
	
	protected void file(LinkedList non_student,LinkedList student,OutputStream os) throws IOException{
		String str =new String();
		String space = "  ";
		String enter="\n";
		if(if_student){
			for(int i=7*(this.number_of_student-1); i  <7*(this.number_of_student); i++){
				str=(String)student.get(i);
				System.out.println("str = " + str);
				os.write(str.getBytes());
				os.write(space.getBytes());
			}
			os.write(enter.getBytes());
		}
		else{
			for(int i=3*(number_of_nonstudent-1);i<3*(number_of_nonstudent);i++){
				str=(String)non_student.get(i);
				os.write(str.getBytes());
				os.write(space.getBytes());
			}
			os.write(enter.getBytes());
		}
	}

	
	/* SET GET */
	
	public String getMajor() {
		return major;
	}

	public void setMajor(String major) {
		this.major = major;
	}

	public String getStudent_number() {
		return Student_number;
	}

	public void setStudent_number(String student_number) {
		Student_number = student_number;
	}

	public String getGrade() {
		return grade;
	}

	public void setGrade(String grade) {
		this.grade = grade;
	}

	public String getScore() {
		return score;
	}

	public void setScore(String score) {
		this.score = score;
	}

	public boolean isIf_student() {
		return if_student;
	}

	public void setIf_student(boolean if_student) {
		this.if_student = if_student;
	}

	
	/* SET GET */
}