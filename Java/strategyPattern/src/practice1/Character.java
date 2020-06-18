package practice1;

public class Character{
	private Weapon weapon;

	public static void main(String[] args) {

	}
	public void doAttack(){
		if(weapon==null){
			System.out.println("맨손공격");
		}else{
			weapon.attack();
		}
	}
	
	/* SET & GET */
	public Weapon getWeapon() {
		return weapon;
	}

	public void setWeapon(Weapon weapon) {
		this.weapon = weapon;
	}
	/* SET & GET */
}
