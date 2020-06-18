package client;

/*
 *  19년도 1학기 객체지향프로그래밍실습 개인 프로젝트
 *  Title : 서버 채팅프로그램 
 *  Class : 서버 채팅프로그램 클라이언트 수신 클래스 (UDP)
 *  2014707073 전자통신공학과 김수환
 */

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.SocketException;

public class ClientReceiver extends Thread implements ClientInterface {
	private SharedArea sArea;
	private DatagramPacket packet;
	private byte[] buf;
	private DatagramSocket socket;

	public ClientReceiver() {
		sArea=null;
		buf=new byte[512];
		
		try {
			socket=new DatagramSocket(CLIENT_PORT);
		} catch (SocketException e) {
			e.printStackTrace();
		}
		packet=new DatagramPacket(buf,buf.length);
	}
	
	@Override
	public void run() {
		try {
			while (true) {
				socket.receive(packet);

				/* 종료시 */
				if(checkQuit(new String(buf))){
					return;
				}
				
				sArea.getTextArea().append(new String(buf) + "\n");
				//System.out.println(new String(buf));
			}
		} catch (SocketException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public boolean checkQuit(String str){
		if(str.toUpperCase().equals(CMD_QUIT)){
			return true;
		}
		return false;
	}
	
	public void setsArea(SharedArea sArea) {
		this.sArea = sArea;
	}
}
