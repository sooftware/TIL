package Client;

import java.io.IOException;
import java.net.Socket;

public class ClientChat {
	public static void main(String[] args) {
		ClientOutputThread out_Thread = new ClientOutputThread();
		ClientInputThread in_Thread = new ClientInputThread();

		out_Thread.start();
		in_Thread.start();
	}
}