package project1;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.SocketException;
import java.util.Vector;

class UDPreceiver extends Thread {
	private Vector<String> order;
	private OrderUI ou;
	
	public void setOrder(OrderUI ou) {
		this.ou = ou;
	}
	
    @Override
    public void run() {
       try {
          DatagramSocket socket = new DatagramSocket(8000);

          while (true) {
             byte[] buf = new byte[512];
             DatagramPacket packet = new DatagramPacket(buf, buf.length);
             socket.receive(packet);
             String str = new String(buf);
             ou.addVector(str);
             System.out.println(ou.getOrder());
             ou.getList().setListData(ou.getOrder());
          }
       } catch (SocketException e) {
          e.printStackTrace();
       } catch (IOException e) {
          e.printStackTrace();
       }
    }

 }