package ex04.Synchronized;

public class MainEntry {
	public static void main(String[] args) {
		Atm at = new Atm(1000);

		UserAtm user1 = new UserAtm(at, "김수환");
		UserAtm user2 = new UserAtm(at, "수환킴");
		UserAtm user3 = new UserAtm(at, "솬킴");

		user1.start();
		user2.start();
		user3.start();
	}
}

/* ATM START */
class Atm {
	private int money;

	public Atm(int money) { // 생성자 함수
		this.money = money;
	}

	/* 입금 함수 */
	public void deposit(int amount, String name) {
		synchronized (this) {
			money += amount;
			System.out.println(name + " : 입금금액 " + amount);
		}
	}
	/* 입금 함수 */

	/* 출금 함수 */
	public void withdraw(int amount, String name) {
		synchronized (this) {
			if (money > amount) {
				Thread.yield();
				money -= amount;
				System.out.println(name + " : 출금금액 " + amount);
			} else {
				System.out.println("ERROR!! 금액이 부족합니다!!!");
			}
		}
	}
	/* 출금 함수 */

	/* 통장 잔고 함수 */
	public void getMoney() {
		System.out.println("                                          잔액은 : " + money + " 입니다.");
	}
	/* 통장 잔고 함수 */
}
/* ATM END */

/* UserAtm START */
class UserAtm extends Thread {
	Atm obj;
	boolean flag = false;

	/* 생성자 함수 */
	public UserAtm(Atm obj, String name) {
		super(name);
		this.obj = obj;
	}

	@Override
	public void run() { // 스레드 구현부 무조건 있어야됨
		for (int i = 0; i < 2; i++) {
			try {
				sleep(50);
			} catch (Exception e) {
				e.printStackTrace();
			}
			if (flag) {

				obj.deposit((int) (Math.random() * 10 + 2) * 100, getName());
				obj.getMoney();

			} else {

				obj.withdraw((int) (Math.random() * 10 + 2) * 100, getName());
				obj.getMoney();
			}
		}

		flag = true;
	} // for end

}
/* UserAtm END */