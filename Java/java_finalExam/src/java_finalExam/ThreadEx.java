package java_finalExam;

public class ThreadEx extends Thread {
	public static void main(String[] args) {
		Thread th = new Thread(new InterThread());
		th.start();
		ClassThread th2 = new ClassThread();
		th2.start();
	}
}

class InterThread implements Runnable {
	@Override
	public void run() {
		while (true) {
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				return;
			}
			System.out.println("Thread1 call!!");
		}
	}
	
}

class ClassThread extends Thread {

	@Override
	public void run() {
		super.run();
		while (true) {
			try {
				Thread.sleep(500);
			} catch (InterruptedException e) {
				return;
			}
			System.out.println("Thread2 call!!");
		}
	}

}
