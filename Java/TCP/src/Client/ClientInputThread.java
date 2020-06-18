package Client;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;
import java.net.UnknownHostException;

public class ClientInputThread extends Thread implements ClientInterface{
	private Socket c_socket;

	// 서버에서 들어오는 메시지 출력
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
			BufferedReader in = new BufferedReader(new InputStreamReader (c_socket.getInputStream()));
			
			while(true) {
				String inputMessage = in.readLine();
				System.out.println("서버 : " + inputMessage);
				
				if(inputMessage.toUpperCase().equals("BYE")) {
					return;
				}
			}
		}
		catch (IOException e) {
			System.out.println(e.getMessage());
		}
		finally {
			try {
				if(c_socket != null) c_socket.close();
			}
			catch(IOException e) {
				System.out.println("서버와 채팅 중 오류가 발생하였습니다. ");
			}
		}
	}
}
