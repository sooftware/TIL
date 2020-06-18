package chat;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;
import java.net.UnknownHostException;
import java.util.Scanner;

public class UdpSenderThread extends Thread {

	@Override
	public void run() {
		// TODO Auto-generated method stub
		// super.run();

		Scanner scan = new Scanner(System.in);
		try {
			DatagramSocket socket = new DatagramSocket();
			while (true) {
				String msg = "SooHwan : "+scan.nextLine();
				byte[] buf = msg.getBytes();
				DatagramPacket packet1 = new DatagramPacket(buf, buf.length, InetAddress.getByName("타켓컴퓨터1의 ip"),
						2000);	
				DatagramPacket packet2 = new DatagramPacket(buf, buf.length, InetAddress.getByName("타켓컴퓨터2의 ip"),
						1000); 
				socket.send(packet1);
				socket.send(packet2);
			}
		} catch (SocketException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (UnknownHostException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}