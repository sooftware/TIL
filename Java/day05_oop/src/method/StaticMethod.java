package method;

import java.util.*;

class b{
	public static void set(){
		System.out.println("2시간 30분 남았드아아~!@!!#@!$@~$");
	}
}

public class StaticMethod {
	public static void main(String[] args) {
		show();
		b.set();
	}
	
	public static void show(){
		System.out.println("2시간 30분 남았드아아~!@!!#@!$@~$");
	}
}

/*
객체명.함수이름() -> 호출방법 ( 같은 class 소속이 아닐때 )
함수이름() -> 호출방법 ( 같은 class 소속일 때 )

앞에 static 붙인다 -> static 함수
앞에 static 안붙인다 -> instance 함수
*/