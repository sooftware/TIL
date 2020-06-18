package Homework1;

public class GolfClub{
	String name;			//	생성자에 따라 다르게 설정되는 필드
	public GolfClub() {		//	인자가 없는 생성자
		this.name="7번 아이언";	// default 값으로 "7번 아이언"을 준다
	}
	
	public GolfClub(int num) {	// int형 인자 하나를 받는 생성자
		this.name=num+"번 아이언"; // 받은 int형 숫자와 string 합쳐서 저장한다
	}
	
	public GolfClub(String name) { // string형 인자 하나를 받는 생성자
		this.name=name;	//	그대로 name에 저장한다
	}
	
	public void print() {
		System.out.println(name+"입니다.");
	}
}
