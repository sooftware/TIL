package ex06.wrapper;

class Point{
	
}

public class MainEntry {
	public static void main(String[] args) {
		Integer la = new Integer(10);
		Integer lb = new Integer("10");
		String strNum="30";
		int x = 10;
		
		Point pt = new Point();
		
		System.out.println("pt = " +pt);
		System.out.println("pt.toString() = " + pt.toString());
		System.out.println("la = " + la);
		System.out.println("la.hashCode() = " + la.hashCode());
		System.out.println("la.getClass().getName@Integer,toHexString(la.hashCode()) : " + la.getClass().getName() + '@' + Integer.toHexString(la.hashCode()));
		System.out.println("pt.hashCode() = " + pt.hashCode());
		
		/* Boxing vs UnBoxing */
		int y=5;
		double d = 3.3;
		y = (int)d;
			
		int c = la.intValue(); // jdk 4.0 이전에 사용하던 method
		int e = lb;		// jdk 5.0 이후부터 heap영역에 있던 객체를 stack memory영역으로 가져올 수 있게됬다
		int num = Integer.parseInt(strNum);
		
		System.out.println(c+strNum);
		System.out.println(c+e);
		System.out.println(la.MAX_VALUE);
		System.out.println(la.MIN_VALUE);
		
		System.out.println(Float.MIN_VALUE);
		System.out.println("================");
		Double dd = new Double(12.34);
		System.out.println(dd.MAX_VALUE);
		System.out.println(dd.MIN_VALUE);
		
		System.out.println("++++++++++++++++");
		c=(int)dd.doubleValue();
		System.out.println("형변환한 c의 값은 ? " + c);
		System.out.println("************************");
	}
}