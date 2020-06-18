package ex02.runnable;

public class MainEntry {
	public static void main(String[] args) {
		new Thread(new UserRunnable("ur")).start();
		new Thread(new UserRunnable("ur2")).start();
		new Thread(new UserRunnable("ur3")).start();
	}
/*	UserRunnable ur = new UserRunnable("SooHwan");
	UserRunnable ur2 = new UserRunnable("SooHwan2");
	Thread t1 = new Thread(ur);	//	runnable에는 start가 없기때문에 만들어준다
	Thread t2 = new Thread(ur2);	//	runnable에는 start가 없기때문에 만들어준다
	
	t1.start();
	t2.start();
	*/
}