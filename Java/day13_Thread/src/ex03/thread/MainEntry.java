package ex03.thread;

public class MainEntry {
	public static void main(String[] args) {
		long id = Thread.currentThread().getId();
		String name = Thread.currentThread().getName();
		int priority = Thread.currentThread().getPriority(); 			// 스테드의 우선순위
		Thread.State state = Thread.currentThread().getState(); 	// 현재 스레드 상태
		
		System.out.println("현재 Thread ID : " + id);	// 시스템이 부여해줌
		System.out.println("현재 Thread name : " + name);
		System.out.println("현재 Thread state : " + state);
		System.out.println("현재 Thread priority : " + priority);
		
	}
}
