package Generic;

public class Main {
	public static void main(String[] args) {
		Box box = new Box();
		box.setData("문자열을 하나 담을 수 있는 객체");
		System.out.println(box.getData());
	}
	
	public static <A> void print(A a,A b){
		boolean result = a.equals(b);
		System.out.println(result);
	}
}

class Box{
	// 방법1
	Object data;
	public Object getData(){
		return data;
	}
	public void setData(Object data){
		this.data = data;
	}

}

class  Box2<A>{
	// 방법2
	A data;
	public A getData(){
		return data;
	}
	public void setData(A data){
		this.data = data;
	}
}

// 호출당시에 타입을 결정할 수 있는 문법 : Generic