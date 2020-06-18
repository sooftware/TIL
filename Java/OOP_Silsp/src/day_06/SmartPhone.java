package day_06;

public class SmartPhone extends Phone{
	String game;
	
	public SmartPhone(String owner,String game) {
		super(owner);
		this.game=game;
	}
	
	public void playGame() {
		super.talk();
		System.out.println(game +"을 하시는 중이십니다");
	}
}
