package ex07.Interface;

interface A{
	int x = 90;	// int x == final int x (interface에서)기본적으로 누워있는다 변수가..
	final int y = 7777;
	
	public void show();	// public abstract void show(); abstract 생략 가능함 - 무조건 추상method
	public abstract void disp();
}	// A END

interface B{
	void view();
}	// B END

interface C{
	String name = "happy";
	public void draw();
}

class Rect implements C{
	public void draw(){
		System.out.println(name + "님 반가워요");
	}
}

interface D extends B{
	
}

public class MainEntry {
	public MainEntry() {
	
	}
}