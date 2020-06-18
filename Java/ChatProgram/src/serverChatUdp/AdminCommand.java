package serverChatUdp;

/*
 * 2019-02-05
 * 서버 채팅프로그램 서버 명령어 클래스 (UDP)
 * 소켓통신스터디
 */

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;
import java.net.UnknownHostException;
import java.util.Iterator;
import java.util.Scanner;
import java.util.Set;

public class AdminCommand extends Thread implements ServerInterface{
	private SharedArea sArea;
	Thread sender, receiver;
	/* Thread 동작 부분 */
	/* Thread 동작 부분 */
	/* Thread 동작 부분 */
	@Override
	public void run() {
		Scanner sc = new Scanner(System.in);
		while (true) {
			String command = sc.next();
			int caseNum = whatCommand(command,sArea.ck);
			
			// 명령 case별 구분 
			switch(caseNum){
			case EXIT:
				System.out.println("AdminCommand 종료...");
				noticeExitToAllClient();	//	현재 채팅방의 모든 인원에게 서버종료를 알린다
				sc.close();
				sender.interrupt();
				receiver.interrupt();
				return;
				
			case SHOW:
				showCurrentClient();
				break;
				
			case BAN:
				banUser();
				break;
			
			case ERROR:
				System.out.println("존재하지 않는 명령어입니다 ^.^");
				break;
			default:
				System.out.println("SWITCH DEFAULT DETECT!");
				break;
			}
			// 명령 case별 구분 
		}
	}
	/* Thread 동작 부분 */
	/* Thread 동작 부분 */
	/* Thread 동작 부분 */

	/* 현재 클라이언트 IP를 보여주는 메서드 */
	public void showCurrentClient() {
		Set<String> idToSet = sArea.client.keySet();		//	Key를 Set으로 변환 -> Iterator를 위한 변환
		Iterator it = idToSet.iterator();		//	clientIP용 Iterator
		int count=0;
		System.out.println("##### 현재 사용중인 클라이언트의 IP 목록 #####");
		while (it.hasNext()) {
			String currentID = it.next().toString();
			count++;
			System.out.println(count + "번째 Client ID : " + currentID);
			System.out.println(count + "번째 Client IP : " + sArea.client.get(currentID));
		}
		System.out.println("\n총 " + count + "명의 Client 접속 중...");
		return;
	}

	/* 종료시 모든 클라이언트에게 서버 종료 메세지를 보내는 메서드 */
	public void noticeExitToAllClient(){
		DatagramSocket socket;
		Set<String> idToSet = sArea.client.keySet();		//	Key를 Set으로 변환 -> Iterator를 위한 변환
		Iterator it = idToSet.iterator();		//	clientIP용 Iterator
		try {
			socket = new DatagramSocket();
			while(it.hasNext()){
				String notice = "Server Down";
				DatagramPacket packet = new DatagramPacket(notice.getBytes(), notice.getBytes().length,	
						InetAddress.getByName(sArea.client.get(it.next().toString())), CLIENT_PORT);		
				socket.send(packet);	// packet 발사! 			
			}
		} catch (SocketException e) {
			e.printStackTrace();
		} catch (UnknownHostException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	/* 유저 밴 메서드 */
	public void banUser(){
		DatagramSocket socket;
		Set<String> idToSet = sArea.client.keySet();		//	Key를 Set으로 변환 -> Iterator를 위한 변환
		Iterator it = idToSet.iterator();									//	clientIP용 Iterator
		Scanner sc = new Scanner(System.in);
		String id;
		boolean first = true;
		
		// ID를 입력받아서 존재하지 않는 ID라면 다시 입력을 받는다. 
		do{
			if(first){	// 처음이면
				System.out.print("강퇴할 ID : ");
				id = sc.next();
				first=false;
			}else{	// 잘못입력하면
				System.out.println("잘못입력하셨습니다 다시 ");
				System.out.print("강퇴할 ID : ");
				id = sc.next();
			}
		}while(!sArea.ck.checkIdExist(id));
		
		// 강퇴당한 클라이언트에게 알림 
		try {
			socket = new DatagramSocket();
			String notice = "ADMIN : 너 강퇴 ㅎ";
			DatagramPacket packet = new DatagramPacket(notice.getBytes(), notice.getBytes().length,	
					InetAddress.getByName(sArea.client.get(id)), CLIENT_PORT);		
			socket.send(packet);	// packet 발사! 			
		} catch (SocketException e) {
			e.printStackTrace();
		} catch (UnknownHostException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		/* 강퇴당한 클라이언트에게 Map에서 삭제 */
		sArea.client.remove(id);
		sc.close();
		return;
	}
	
	public int whatCommand(String command,Check ck){
		if(sArea.ck.checkServerExit(command)) return 0;			//	서버종료
		else if(sArea.ck.checkShow(command)) return 1;				//	현재 유저 목록
		else if(sArea.ck.checkBanUser(command)) return 2;		//	강퇴
		else if(sArea.ck.checkUserOut()) return 3;							//	유저가 나갔는지
		else return -1;																		//	그 외
	}
	
	/* Set & Get */
	
	public void setsArea(SharedArea sArea) {
		this.sArea = sArea;
	}
	
	public void setSender(Thread th){
		this.sender=th;
	}
	
	public void setReceiver(Thread th){
		this.receiver=th;
	}
	
	/* Set & Get */
}