package day08;

public class MaxTest {
	public static void main(String[] args) {
`		Max m = new Max();
		System.out.println(m.max(10.0,8.0));
		System.out.println(m.max(5,8.0));
		System.out.println(m.max(5,3.0));
	}
}

class Max <T extends Number>{
	public T max(T n1,T n2) {
		if(n1.doubleValue() > n2.doubleValue()) return n1;
		else return n2;
	}
}