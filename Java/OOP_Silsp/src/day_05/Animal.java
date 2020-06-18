package day_05;

public abstract class Animal{
	Animal animal;
	
	public abstract void attack();

	public void doAttack(Animal animal) {
		animal.attack();
	}

}
