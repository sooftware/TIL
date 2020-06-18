package ex01.thread;

public class UserThread extends Thread{
	String name;
	
	public UserThread(String name){
		this.name = name;
	}

	@Override
	public void run() {	// 실제 스레드 실행부(구현부)
	//	System.out.println(name);
	//	System.out.println("start 메소드에 의해 run()이 유도된다 (실행대기)");
			for(int i=0;i<=10;i++){
				if(i==7){
					try {
						sleep(100);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
					System.out.println(name);
				}
				System.out.println(i);
			}
	}
}
