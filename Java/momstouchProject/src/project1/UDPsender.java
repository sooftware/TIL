package project1;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;
import java.net.UnknownHostException;
import java.util.Scanner;

public class UDPsender {
	public UDPsender(String rocket) {
		while (true) {
			try {
				DatagramSocket socket = new DatagramSocket();
				byte[] buf = rocket.getBytes();
				DatagramPacket packet = new DatagramPacket(buf, buf.length, InetAddress.getByName("192.168.0.25"),
						5000);
				socket.send(packet);

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
}
