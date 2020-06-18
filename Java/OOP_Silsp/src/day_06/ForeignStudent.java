package day_06;

public class ForeignStudent extends Student{
	String country;
	ForeignStudent(String name,int age,int studentNo,String country){
		super(name,age,studentNo);
		this.country=country;
	}
	
	public void print() {
		super.print();
		System.out.println("Country : "+country);
	}
}
