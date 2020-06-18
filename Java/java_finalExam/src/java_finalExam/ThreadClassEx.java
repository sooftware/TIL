package java_finalExam;

public class ThreadClassEx {
	public static void main(String[] args) {
		ThreadClass th = new ThreadClass();
		th.start();
	}
}

class ThreadClass extends Thread {
	@Override
	public void run() {
		super.run();
		while (true) {
			try {
				Thread.sleep(500);
			} catch (InterruptedException e) {
				return;
			}
			System.out.println("ThreadClass");
		}
	}
}