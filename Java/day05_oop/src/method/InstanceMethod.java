package method;
import java.util.*;

class A{
	int x,y;
	public void setData(int x,int y){
		System.out.println(x + ", " + y);
	}
}

public class InstanceMethod {
	public void disp(){
		System.out.println("name = SooHwan");
	}
	
	public static void main(String[] args) {
		InstanceMethod im = new InstanceMethod(); // 이게 바로 Instance Method!!
												  // 객체를 만들어서 써야하는 Method!!
		A obj = new A();
		obj.setData(4,5);
		im.disp();		// Scanner를 쓸때처럼 쓰면 된다고 생각!!
	}
}

/*
 정말 중요한 부분!!!!! InstanceMethod에 대한 개념 철저하게 이해할 것!!
 */
