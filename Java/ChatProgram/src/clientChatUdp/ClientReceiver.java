package clientChatUdp;

/*
 * 2019-02-05
 * 서버 채팅프로그램 클라이언트 수신 클래스 (UDP)
 * 소켓통신스터디
 */

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.SocketException;

public class ClientReceiver extends Thread implements ClientInterface{
	private SharedArea sArea;
	@Override
	public void run() {
		try {
			DatagramSocket socket = new DatagramSocket(CLIENT_PORT);
			while (true) {
				if(sArea.quit){
					return;
				}
				byte[] buf = new byte[512];
				DatagramPacket packet = new DatagramPacket(buf, buf.length);
				socket.receive(packet);
				System.out.println(new String(buf));
			}
		} catch (SocketException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public void setsArea(SharedArea sArea) {
		this.sArea = sArea;
	}
}
