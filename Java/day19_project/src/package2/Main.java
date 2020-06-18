package package2;

public class Main extends Thread{
	public static void main(String[] args) {
		UdpReceiver ur = new UdpReceiver();
		UdpSender1 us1 = new UdpSender1();
		
		ur.start();
		us1.start();
	}
}
