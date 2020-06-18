package day_04;

public class DiceTest {
	public static void main(String[] args) {
		Dice d = new Dice();
		System.out.println("숫자 : " + d.roll());
		System.out.println("숫자 : " + d.roll());
		System.out.println("숫자 : " + d.roll());
		System.out.println("숫자 : " + d.roll());
		System.out.println("숫자 : " + d.roll());
		System.out.println("숫자 : " + d.roll());
	}
}

class Dice{
	public int roll() {
		return (int)(Math.random()*5)+1;
	}
}
