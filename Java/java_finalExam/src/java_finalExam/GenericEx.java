package java_finalExam;

import java.util.LinkedList;

public class GenericEx {
	public static void main(String[] args) {
		LinkedListGen<LinkedList> llg = new LinkedListGen<LinkedList>();
		LinkedList<Integer> list = new LinkedList<Integer>();
		
		list.add(1);
		
		llg.set(list);
		System.out.println(llg.get());
	}
}

class LinkedListGen <T>{
	T val;
	
	void set(T val){
		this.val=val;
	}
	
	T get(){
		return val;
	}
}
