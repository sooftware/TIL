package clientChatUdp;

/*
 * 2019-02-05
 * 서버 채팅프로그램 클라이언트 Main 클래스 (UDP)
 * 소켓통신스터디
 */

public class ClientMain {
	public static void main(String[] args) {
		ClientReceiver cReceiver = new ClientReceiver();
		ClientSender cSender = new ClientSender();
		SharedArea sharedArea = new SharedArea();
		
		cReceiver.setsArea(sharedArea);
		cSender.setsArea(sharedArea);
		
		/* Client Thread Start! */
		cSender.start();
		cReceiver.start();
		/* Client Thread Start! */
		
		try {
			/* Thread Return Together */
			cSender.join();
			cReceiver.join();
			/* Thread Return Together */
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		return;
	}
	
	
}