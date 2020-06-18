package day_06;

public class Student extends Person{
	int studentNo;
	Student(String name,int age,int studentNo){
		super(name,age);
		this.studentNo=studentNo;
	}
	
	public void print() {
		super.print();
		System.out.println("studentNo : "+ studentNo);
	}
}
