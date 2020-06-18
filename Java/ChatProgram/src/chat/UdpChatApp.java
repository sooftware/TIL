package chat;

public class UdpChatApp {
	public static void main(String[] args) {
		UdpReceiverThread urt = new UdpReceiverThread();
		UdpSenderThread ust = new UdpSenderThread();
		urt.start();
		ust.start();
	}
}