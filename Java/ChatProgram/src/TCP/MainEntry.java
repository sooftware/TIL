package TCP;

public class MainEntry {
	public MainEntry() {
		ClientReceiveTh crt = new ClientReceiveTh();
		ClientSenderTh cst = new ClientSenderTh();
	}
}