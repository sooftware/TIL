package fourth;

public class dasd{
	public static void main(String[] args) {
		String a = new String("This is a pencil");
		String b = new String("This is a pencil");
		String c = a;
		
		if(a==b)
			System.out.println("a==b");
		if(a==c)
			System.out.println("a==c");
		if(a.equals(b))
			System.out.println("a is equal to b");
	}
}
