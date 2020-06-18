package ex04.Static;

class ATM{
	int count=0;	// instance member
	static int total;	// static member
	
	public ATM(int account){	//	constructor method
		count += account;
		total += account;
	}
	public void display(){
//		count = count + 200;
//		total = total + 200;
		System.out.println("count = " + count);
		System.out.println("total = " + total);
	}
}

public class MainEntry {
	public static void main(String[] args) {
		System.out.println(ATM.total);
		
		System.out.println("=================");
		
		ATM at = new ATM(1000);
		at.display();
		
		System.out.println("=================");
		
		ATM at2 = new ATM(1000);
		at2.display();
		
		System.out.println("=================");
		
		ATM at3 = new ATM(1000);
		at3.display();
	}
}