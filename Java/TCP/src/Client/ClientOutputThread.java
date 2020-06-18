package Client;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;

public class ClientOutputThread extends Thread implements ClientInterface{
	Scanner scanner = new Scanner(System.in);

	private Socket c_socket;

	@Override
	public void run() {
		try {
			c_socket = new Socket(SERVER_IP,TCP_PORT);
		} catch (UnknownHostException e1) {
			e1.printStackTrace();
		} catch (IOException e1) {
			e1.printStackTrace();
		}
		try {
			BufferedWriter out = new BufferedWriter(new OutputStreamWriter(c_socket.getOutputStream()));

			while (true) {
				String outputMessage = scanner.nextLine();
				if (outputMessage.equalsIgnoreCase("bye")) {
					out.write(outputMessage + "\n");
					out.flush();
					break;
				}
				out.write(outputMessage + "\n");
				out.flush();
			}
		} catch (IOException e) {
			System.out.println(e.getMessage());
		} finally {
			try {
				scanner.close();
				if (c_socket != null)
					c_socket.close();
			} catch (IOException e) {
				System.out.println("서버와 채팅 중 오류가 발생하였습니다. ");
			}
		}
	}
}
