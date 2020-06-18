package day08;

public class PairTest {
	public static void main(String[] args) {
		Pair<Integer> p1 = new Pair<>(10,20);
		Pair<Double> p2 = new Pair<>(10.0,20.0);
		
		System.out.println(p1.showFirst());
		System.out.println(p2.showFirst());
	}
}

class Pair <T>{
	T first,second;
	public Pair(T first,T second) {
		this.first=first;
		this.second=second;
	}
	
	public T showFirst() {
		return this.first;
	}
}