package day08;

import java.util.ArrayList;

public class BoxTest {
	public static void main(String[] args) {
		Box<Integer> b = new Box<Integer>();
		b.set(100);
		System.out.println(b.get());
		Box<String> i = new Box<String>();
		i.set("Hello");
		System.out.println(i.get());
	}
}

class Box <T>{
	T obj;
	public void set(T obj) {
		this.obj=obj;
	}
	public T get() {
		return obj;
	}
}