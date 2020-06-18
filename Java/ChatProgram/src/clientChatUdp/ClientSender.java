
package clientChatUdp;

/*
 * 2019-02-05
 * 서버 채팅프로그램 클라이언트 송신 클래스 (UDP)
 * 소켓통신스터디
 */

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;
import java.net.UnknownHostException;
import java.util.Scanner;

public class ClientSender extends Thread implements ClientInterface{
	private SharedArea sArea;
	DatagramSocket socket;
	/* Thread 동작 부분 */
	/* Thread 동작 부분 */
	/* Thread 동작 부분 */
	@Override
	public void run() {
		Scanner sc = new Scanner(System.in);
		String clientID="defaultID";
		try {
			socket=new DatagramSocket();
		} catch (SocketException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		/* 
		 * 맨 처음 실행할 때 
		  * 자신이 원하는 ID를 서버에 보낸다 
		  *  서버는 IP와 ID를 Key,Value로 저장한다
		  *  Value : IP , Key : ID
		  *   */
		/*
		try {
			System.out.print("원하는 ID를 입력하세요 : ");
			clientID = sc.nextLine();
			DatagramSocket socket = new DatagramSocket();
			DatagramPacket loginPacket = new DatagramPacket(clientID.getBytes(),
					clientID.getBytes().length,
					InetAddress.getByName(SERVER_IP), SERVER_PORT);
			socket.send(loginPacket);
		} catch (UnknownHostException e1) {
			e1.printStackTrace();
		} catch (SocketException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		*/
		System.out.println("##### 서버에 송신 성공 #####");	// 여기까지 실행됬다면, 서버에 송신까지는 성공!
		
		try {
			while (true) {
				/*
				String userInput = sc.nextLine();
				
				checkQuit(userInput);	// quit을 입력받으면 종료하도록
				
				String msg = clientID + " : "+userInput;
				byte[] buf = msg.getBytes();
				DatagramPacket packet;
				
				if(sArea.quit){
					String q = "QUIT";
					packet = new DatagramPacket(q.getBytes(), q.length(), 
							InetAddress.getByName(SERVER_IP), SERVER_PORT);
					socket.send(packet);
					sc.close();
					return;	// 종료를 원하면 서버에 quit를 보내고 종료한다.
				}
				
				packet = new DatagramPacket(msg.getBytes(), msg.getBytes().length, 
						InetAddress.getByName(SERVER_IP), SERVER_PORT);
				socket.send(packet);
				*/
				clientID = sc.nextLine();
				DatagramPacket loginPacket = new DatagramPacket(clientID.getBytes(),
						clientID.getBytes().length,
						InetAddress.getByName(SERVER_IP), SERVER_PORT);
				socket.send(loginPacket);
			}
		} catch (SocketException e) {
			e.printStackTrace();
		} catch (UnknownHostException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	/* Thread 동작 부분 */
	/* Thread 동작 부분 */
	/* Thread 동작 부분 */
	
	
	
	/* 사용자가 종료키워드를 입력했는지 검사하는 메서드 */
	public void checkQuit(String userInput){
		if(userInput.toUpperCase().equals("QUIT")){
			sArea.quit=true;
		}
		return;
	}

	public void setsArea(SharedArea sArea) {
		this.sArea = sArea;
	}
}