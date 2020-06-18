package java_finalExam;

public class RunnableThreadEx {
	public static void main(String[] args) {
		Thread th = new Thread(new RunnableThread());
		th.start();
	}
}

class RunnableThread implements Runnable {
	@Override
	public void run() {
		while (true) {
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				return;
			}
			System.out.println("RunnableThread");
		}
	}
}