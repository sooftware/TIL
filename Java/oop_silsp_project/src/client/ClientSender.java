package client;

/*
 *  19년도 1학기 객체지향프로그래밍실습 개인 프로젝트
 *  Title : 서버 채팅프로그램 
 *  Class : 서버 채팅프로그램 클라이언트 송신 클래스 (UDP)
 *  2014707073 전자통신공학과 김수환
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
	private Thread receiver;
	private DatagramSocket socket;
	private DatagramPacket packet;
	private Scanner sc;
	public ClientSender() {
		sArea=null;
		receiver=null;
		try {
			socket=new DatagramSocket();
		} catch (SocketException e) {
			e.printStackTrace();
		}
		sc = new Scanner(System.in);
	}
	
	/* Thread 동작 부분 */
	/* Thread 동작 부분 */
	/* Thread 동작 부분 */
	@Override
	public void run() {
		/* 
		 * 맨 처음 실행할 때 
		 * 자신이 원하는 ID를 서버에 보낸다 
		 *  서버는 IP와 ID를 Key,Value로 저장한다
		 *  Value : IP , Key : ID
		 */
		String clientID=makeID();
		
		System.out.println("##### 서버에 송신 성공 #####");	// 여기까지 실행됬다면, 서버에 송신까지는 성공!
		
		try {
			while (true) {
				String userInput = sc.nextLine();
				
				checkQuit(userInput);	// quit을 입력받으면 종료하도록
				
				String msg = clientID + " : "+userInput;
				byte[] buf = msg.getBytes();
				DatagramPacket packet =new DatagramPacket(buf, buf.length, 
						InetAddress.getByName(SERVER_IP), SERVER_PORT);
				
				/* 종료시 */
				if(sArea.isQuit()){
					cSenderFinish(packet,socket);
					sc.close();
					receiverFinish(receiver);
					return;	// 종료를 원하면 서버에 quit를 보내고 종료한다.
				}
				
				socket.send(packet);
			}
		} catch (SocketException e) {
			e.printStackTrace();
		} catch (UnknownHostException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return;
	}
	/* Thread 동작 부분 */
	/* Thread 동작 부분 */
	/* Thread 동작 부분 */
	
	/* 유저 아이디를 만들어서 리턴 */
	public String makeID(){
		String clientID="defaultID";
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
		return clientID;
	}
	
	/* 사용자가 종료키워드를 입력했는지 검사하는 메서드 */
	public void checkQuit(String userInput){
		if(userInput.toUpperCase().equals(CMD_QUIT)){
			sArea.setQuit(true);
		}
		return;
	}
	
	/* cSender 종료시 */
	public void cSenderFinish(DatagramPacket packet,DatagramSocket socket){
		String q = CMD_QUIT;
		try {
			packet = new DatagramPacket(q.getBytes(), q.length(), 
					InetAddress.getByName(SERVER_IP), SERVER_PORT);
			socket.send(packet);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return;
	}

	/* receiver 스레드 종료 */
	public void receiverFinish(Thread th){
		th.interrupt();
	}
	
	/* SET & GET */
	
	public void setsArea(SharedArea sArea) {
		this.sArea = sArea;
	}
	
	public void setReceiver(Thread th){
		this.receiver=th;
	}
	
	/* SET & GET */
}