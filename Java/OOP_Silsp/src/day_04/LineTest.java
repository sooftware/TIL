package day_04;

public class LineTest {
	public static void main(String[] args) {
		Line ln1 = new Line(1);
		Line ln2 = new Line(1);
		
		System.out.println(ln1.isSameLine(ln2));
		System.out.println(ln1==ln2);
	}
}

class Line{
	private int length;
	
	Line(int length) {
		this.length=length;
	}
	
	public boolean isSameLine(Line ln) {
		return this.length == ln.length;
	}
	
	public int getLength() {
		return length;
	}
}
