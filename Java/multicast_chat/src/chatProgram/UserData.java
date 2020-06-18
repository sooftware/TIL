package chatProgram;

/*
 * KwangWoon University
 * 2019년도 1학기 객체지향프로그래밍실습 
 * 개인프로젝트
 * 전자통신공학과 2014707073 김수환
 * 주제 : 멀티캐스트 다중 채팅 프로그램
 * Class : 각 user의 데이터를 가지고 있는 클래스
 */

public class UserData {
	private String id;
	private String pw;
	private String name;
	
	/* UserData 생성자 */
	UserData(){
		id=null;
		pw=null;
		name=null;
	}

	/* Set & Get Method */

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getPw() {
		return pw;
	}

	public void setPw(String pw) {
		this.pw = pw;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	/* Set & Get Method */
}
