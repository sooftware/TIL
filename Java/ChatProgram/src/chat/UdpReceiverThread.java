package chat;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.SocketException;

public class UdpReceiverThread extends Thread {

	@Override
	public void run() {
		// TODO Auto-generated method stub
		// super.run();

		try {
			DatagramSocket socket = new DatagramSocket(3000);
			while (true) {
				byte[] buf = new byte[512];
				DatagramPacket packet = new DatagramPacket(buf, buf.length);
				socket.receive(packet);
				System.out.println(packet.getAddress() + new String(buf).trim());
			}
		} catch (SocketException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
