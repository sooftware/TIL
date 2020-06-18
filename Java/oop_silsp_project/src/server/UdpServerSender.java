package server;

/*
 *  19년도 1학기 객체지향프로그래밍실습 개인 프로젝트
 *  Title : 서버 채팅프로그램 
 *  Class : 서버 채팅프로그램 서버 송신 클래스 (UDP)
 *  2014707073 전자통신공학과 김수환
 */

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;
import java.net.UnknownHostException;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Scanner;
import java.util.Set;

public class UdpServerSender extends Thread  implements ServerInterface{
	private SharedArea sArea;
	private DatagramSocket socket;
	
	public UdpServerSender() {
		sArea=null;
		try {
			socket=new DatagramSocket();
		} catch (SocketException e) {
			e.printStackTrace();
		}
	}
	
	/* Thread 동작 부분 start */
	/* Thread 동작 부분 start */
	/* Thread 동작 부분 start */
	@Override
	public void run() {
		try {
/* 
	메세지가 안들어왔다면 어차피 wait 상태가 될 것이고 
	메세지가 들어왔다면 일단 메세지를 전체적으로 뿌려줘야할 것이기 때문에
	Sender의 전체 while부분을 동기화 부분으로 지정한다.
*/
			while (true) {
				synchronized(sArea){
					Set<String> idToSet = sArea.client.keySet();		//	id 부분만 Set으로 변환 -> Iterator를 위한 변환
					Iterator it = idToSet.iterator();									//	client ID 검색용 Iterator
					Set<String> testSet = sArea.client.keySet();	
					Iterator testIt = testSet.iterator();						
					
					/* 만약 메시지가 들어왔다면 */
					if (sArea.isReady) {
						while(testIt.hasNext()){
							String str = testIt.next().toString();
							System.out.println("ID : "+ str);
							System.out.println("IP : "+ sArea.client.get(str));
						}
						
						
						System.out.println(new String(sArea.msg).trim());
						byte[] buf =new byte[512];
						buf = new String(sArea.msg).trim().getBytes(); // 클라이언트가 보낸 msg를 receive에서 받고 여기서 뿌려준다 
						// clientIP에 저장해놓은 클라이언트 ip를 저장한 개수만큼 꺼낸다
						
						while (it.hasNext()) { 
							 // buf에 저장한 msg를  클라이언트 ip로 보내기 위한 준비 sArea.clientIP.get(sArea.it.next())는
							 //  Map형태의 clientIP에서 sArea.it (clientIP용 Iterator)로 얻은 Key 값인 ID를 이용하여 IP를 찾는다
							DatagramPacket packet = new DatagramPacket(buf, buf.length,	
									InetAddress.getByName(sArea.client.get(it.next().toString())), CLIENT_PORT);
							socket.send(packet);	// packet 발사! 
						}
						initiateSharedArea();	// 메시지를 뿌려주고 난 뒤 초기화
					} else { 
						try {
							sArea.wait();	// 메시지가 들어오지 않았다면 스레드 wait
						} catch (InterruptedException e) {
							System.out.println("Sender 종료...");
							return;
						}
					}
					/* 서버종료 */
					if(sArea.exit){
						return;
					}
				}
			}
		} catch (UnknownHostException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
	/* Thread 동작 부분 End */
	/* Thread 동작 부분 End */
	/* Thread 동작 부분 End */

	public void initiateSharedArea(){
		sArea.isReady = false;
		sArea.msg = null;
	}
	
	/* SharedArea 객체 설정 메서드 */
	public void setsArea(SharedArea sArea) {
		this.sArea = sArea;
	}
}