package package2;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;
import java.net.UnknownHostException;
import java.util.Scanner;

public class UdpSender1 extends Thread {
	// 1. 소켓준비
	// 2. 보낼 데이터를 byte[]로 준비
	// 3. 목적지와 보낼데이터를 실어서 DatagramPacket 준비
	// 4. 3을 1에 올려놓고 발사
	public void run() {
		Scanner sc = new Scanner(System.in);
		DatagramPacket packet1;
		DatagramPacket packet2;
		DatagramPacket packet3;
		DatagramPacket packet4;
		DatagramPacket packet5;
		try {
			System.out.println("채팅프로그램!!");
			while (true) {
				String msg = "뀨!!!! : " + sc.next();
				// 1. 소켓준비
				DatagramSocket socket = new DatagramSocket();
				// 2. 보낼 데이터를 byte[]로 준비

				byte[] buf = msg.getBytes();
				// 3. 목적지와 보낼데이터를 실어서 DatagramPacket 준비
				packet1 = new DatagramPacket(buf, buf.length, InetAddress.getByName("192.168.0.23"), 5000);
				packet2 = new DatagramPacket(buf, buf.length, InetAddress.getByName("192.168.0.55"), 9000);
				packet3 = new DatagramPacket(buf, buf.length, InetAddress.getByName("192.168.0.25"), 11000);
				packet4 = new DatagramPacket(buf, buf.length, InetAddress.getByName("192.168.0.26"),7000);
				packet5 = new DatagramPacket(buf, buf.length, InetAddress.getByName("192.168.0.45"), 8000);
				
				try {
					socket.send(packet1);
					socket.send(packet2);
					socket.send(packet3);
					socket.send(packet4);
					socket.send(packet5);
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			// 4. 3을 1에 올려놓고 발사
		} catch (SocketException | UnknownHostException e) {
			e.printStackTrace();
		}
	}
}

/*
 * UDP 데이터 전송하기
 * 
 * UDP데이터를 전송하려면, UDP데이터는 단위를 데이터그램 이라고 부른다 비행기가 날라가려면 활주로가 필요한것처럼 UDP데이터그램이
 * 날아가려면 UDP데이터그램을 날릴 수 있는 활주로가 필요한데 그녀석이 UDP소켓이다
 * 
 * 고로, 우리가 할 일
 * 
 * 1. UDP소켓 준비 2. 보낼 데이터 준비 3. 보낼 데이터를 UDP데이터그램으로 준비 4. 발사!
 * 
 */