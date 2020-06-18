package TCP;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.Socket;
import java.util.Scanner;

public class ClientReceiveTh extends Thread{
	public ClientReceiveTh() {
		BufferedReader in = null;
		Socket socket = null;
		
		try {
			socket = new Socket("10.20.7.75", 5550);
			in = new BufferedReader(new InputStreamReader (socket.getInputStream()));
			
			while(true) {
				String inputMessage = in.readLine();
				System.out.println("서버 : " + inputMessage);
			}
		}
		catch (IOException e) {
			System.out.println(e.getMessage());
		}
		finally {
			try {
				if(socket != null) socket.close();
			}catch(IOException e) {
				System.out.println("서버와 채팅 중 오류가 발생하였습니다. ");
			}
		}
	}
}
