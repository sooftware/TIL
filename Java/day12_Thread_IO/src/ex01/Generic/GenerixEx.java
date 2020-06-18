package ex01.Generic;

public class GenerixEx<T> {
	T[] v;
	
	public void set(T[] v){
		this.v=v;
	}
	
	public void print(){
		for(T item : v){
			System.out.println(item);
		}
	}
}
