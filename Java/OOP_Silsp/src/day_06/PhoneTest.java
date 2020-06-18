package day_06;

public class PhoneTest {
	public static void main(String[] args) {
		Telephone tp = new Telephone("±è¼öÈ¯","Á» ÀÌµû");
		SmartPhone s= new SmartPhone("±è¼öÈ¯2","°¶·¯±×");
		
		tp.autoAnswering();
		s.playGame();
	}
}