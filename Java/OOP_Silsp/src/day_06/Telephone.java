package day_06;

public class Telephone extends Phone{
	private String when;
	
	public Telephone(String owner,String when) {
		super(owner);
		this.when=when;
	}

	void autoAnswering() {
		super.talk();
		System.out.println("통화 중이니 " + when+"에 다시 전화주시길 바랍니다.");
	}
}
