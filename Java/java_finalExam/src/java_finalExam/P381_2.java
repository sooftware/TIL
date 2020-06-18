package java_finalExam;

public class P381_2 {
	public static void main(String[] args) {
		String s = Integer.valueOf(20).toString();
		double d = Double.valueOf(Double.parseDouble("35.9"));
		boolean a = Boolean.valueOf(Boolean.parseBoolean("true"));
		String s2 = Integer.toBinaryString(30);
		String c = String.valueOf('c');
		
		System.out.println(s);
		System.out.println(d);
		System.out.println(a);
		System.out.println(s2);
		System.out.println(c);
		
		String a1 = "가나다라";
		System.out.println(a1 == "가나다라");
		String b1 = new String(a1);
		System.out.println(a1==b1);
		
		String q = "            Oh, Happy          ";
		String w = q.trim();
		String e = w.concat("Day.");
		
		System.out.println(q);
		System.out.println(w);
		System.out.println(e);
	}
}
