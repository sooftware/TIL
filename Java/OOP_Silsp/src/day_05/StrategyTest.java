package day_05;

public class StrategyTest {
	public static void main(String[] args) {
		Animal animal=new Cat();
		
		animal.doAttack(new Cat());
		animal.doAttack(new Dog());
		animal.doAttack(new Tiger());
		
	}
}
