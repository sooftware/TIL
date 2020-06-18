package package2;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.SocketException;

public class UdpReceiver extends Thread {
	public void run() {
		// 1. 받을 포트를 물고 늘어지는 소켓 객체를 생성
		try {
			DatagramSocket socket = new DatagramSocket(5000);
			byte[] buf = new byte[512];
			DatagramPacket packet = new DatagramPacket(buf, buf.length);

			while (true) {
				
					socket.receive(packet);
					
					System.out.println(new String(buf).trim());

			}
		} catch (SocketException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		// 2. 받을 데이터를 담을 빈 바이트배열을 준비

		// 3. 2를 연결시켜서 빈 패킷을 준비

		// 4. 3을 1에 갖다 대놓고 수신을 대기
	}
}