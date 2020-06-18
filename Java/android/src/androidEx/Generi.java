package androidEx;

import java.util.ArrayList;

public class Generi {
	public static void main(String[] args) {
		ArrayList<String> list = new ArrayList<String>();
		Person<String> soohwan = new Person<String>();
		
		list.add("a");
		list.add("b");
		list.add(3);// <- String으로 타입 제한을 뒀는데 3을 넣어줘서 오류
	}
}

class Person <T>{
	public T info;
}
