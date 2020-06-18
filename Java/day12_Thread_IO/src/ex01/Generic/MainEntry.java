package ex01.Generic;

public class MainEntry {
	public static void main(String[] args) {
		GenerixEx<String> t1 = new GenerixEx<String>();	// 이런 오타나서 그냥 generix로감..
		String[] str = {"abc","kbs","dirotor"};
		t1.set(str);
		t1.print();
		System.out.println("=================");
		GenerixEx<Integer> t2 = new GenerixEx<Integer>();
		Integer[] num = {1,2,3,4,5,6,7,8};
		t2.set(num);
		t2.print();
		System.out.println("=================");
		GenerixEx<Double> t3 = new GenerixEx<Double>();
		Double[] ddo = {1.0,2.0,3.0};
		t3.set(ddo);
		t3.print();
		System.out.println("=================");
	}
}
