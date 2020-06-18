package java_finalExam;

import java.util.Stack;

public class ReverseStack {
	public static void main(String[] args) {
		Stack<String> s = new Stack<String>();
		MyStack<String> ms = new MyStack<String>();
		
		s.add("김");
		s.add("수");
		s.add("환");
		s.add("무");
		s.add("거");
		s.add("북");
		s.add("이");
		s.add("와");
		s.add("두");
		s.add("루");
		s.add("미");
		
		s =ms.reverseStack(s);
		
		System.out.println(s);
	}
}

class MyStack<T>{
	public  <T> Stack reverseStack(Stack<T> s) {
		Stack<T> newS = new Stack<T>();

		while (true) {
			T tmp = s.pop();
			
			if(s==null){
				break;
			}else{
				newS.push(tmp);
			}
		}
		
		return newS;
	}
}
