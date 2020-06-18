package StrategyPattern;

public class Character {
	Weapon weapon;
	
	public void doAttack() {
		if(weapon==null) {
			System.out.println("맨손 공격!!");
		}else {
			weapon.attack();
		}
	}

	public void setWeapon(Weapon weapon) {
		this.weapon = weapon;
	}
}
